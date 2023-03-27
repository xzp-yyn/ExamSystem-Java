package com.xzp.service;

import com.xzp.pojo.po.StudentQuestion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzp.pojo.vo.student.StudentQuestionVO;

import java.util.List;

/**
 * 学生服务
 *
 * @author wangpeng
 * @description  针对表【s_student_question(学生答题表)】的数据库操作Service
 * @createDate 2022-04-10 13:50:27
 * @date 2023/03/26
 */
public interface StudentQuestionService extends IService<StudentQuestion> {

    List<StudentQuestionVO> getQuestionPercen();

}
