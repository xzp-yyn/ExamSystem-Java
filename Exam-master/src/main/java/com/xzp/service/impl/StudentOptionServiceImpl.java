package com.xzp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzp.mapper.StudentOptionMapper;
import com.xzp.pojo.po.StudentOption;
import com.xzp.service.StudentOptionService;
import org.springframework.stereotype.Service;

/**
 * 学生选择服务impl
 *
 * @author 薛展鹏
 * @description 针对表【s_student_option】的数据库操作Service实现
 * @date 2023/03/28
 */
@Service
public class StudentOptionServiceImpl extends ServiceImpl<StudentOptionMapper, StudentOption>
    implements StudentOptionService{

}




