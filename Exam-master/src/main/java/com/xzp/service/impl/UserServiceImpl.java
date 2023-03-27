package com.xzp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzp.mapper.StudentExamMapper;
import com.xzp.pojo.po.StudentExam;
import com.xzp.pojo.po.User;
import com.xzp.service.UserService;
import com.xzp.mapper.UserMapper;
import com.xzp.other.utils.ObjectRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * 用户服务impl
 *  针对表【sys_user(用户表)】的数据库操作Service实现
 * @author 薛展鹏
 * @date 2023/03/26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StudentExamMapper studentExamMapper;

    private String TOKEN_PRO="token:";

    @Override
    public void redisSaveCode(String key, String code) {
        // 超时2分钟
        redisTemplate.opsForValue().set(key, code, 2, TimeUnit.MINUTES);
    }

    @Override
    public String redisGetCode(String key) {
        Boolean flag = redisTemplate.hasKey(key);
        if (Boolean.FALSE.equals(flag)) return null;
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void redisRemoveCode(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void redisSaveUser(String token, User user) {
        // key是token，value是用户保存到redis中，超时时间24小时
        redisTemplate.opsForValue().set(TOKEN_PRO+token, user, 24, TimeUnit.HOURS);
    }

    @Override
    public User redisGetUser(String token) {
        // 根据token得到user
        return (User) redisTemplate.opsForValue().get(TOKEN_PRO+token);
    }

    @Override
    public void redisRemoveUser(String token) {
        // 移除token
        redisTemplate.delete(TOKEN_PRO+token);
    }

    @Override
    public User checkExistsUsername(String username) {
        // 检查username是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public void deleteUser(User user) throws RuntimeException {
        if (user.getId() == 1) {
            throw new RuntimeException("主管理员无法删除");
        }
        QueryWrapper<StudentExam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", user.getId());
        Long count = studentExamMapper.selectCount(queryWrapper);
        if (count != 0) {
            throw new RuntimeException("该用户还有考试记录存在，不能删除！");
        }
        baseMapper.deleteById(user);
    }

    @Override
    public User selectUser(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        queryWrapper.eq(User::getUsername,username);
        User user = this.baseMapper.selectOne(queryWrapper);
        return user;
    }
}
