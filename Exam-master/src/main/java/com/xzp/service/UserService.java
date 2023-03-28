package com.xzp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzp.pojo.po.User;

/**
 * 用户服务
 *
 * @author 薛展鹏
 * @description 针对表【sys_user(用户表)】的数据库操作Service
 * @date 2023/03/28
 */
public interface UserService extends IService<User> {

    /**
     * 保存验证码
     * @param key
     * @param code
     */
    void redisSaveCode(String key, String code);

    /**
     * 获取验证码
     * @param key
     * @return
     */
    String redisGetCode(String key);

    /**
     * 移除验证码
     * @param key
     */
    void redisRemoveCode(String key);

    /**
     * 保存用户
     * @param token
     * @param user
     */
    void redisSaveUser(String token, User user);

    /**
     * 查询用户
     * @param token
     * @return
     */
    User redisGetUser(String token);

    /**
     * 移除用户
     * @param token
     */
    void redisRemoveUser(String token);

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    User checkExistsUsername(String username);

    /**
     * 删除用户
     * @param user
     */
    void deleteUser(User user);

    User selectUser(String username);

    String getNameByExamId(Integer id);

}
