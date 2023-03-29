package com.xzp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzp.pojo.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 用户映射器
 *  针对表【sys_user(用户表)】的数据库操作Mapper
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    String getNameByExamId(@Param("id") Integer id);

}




