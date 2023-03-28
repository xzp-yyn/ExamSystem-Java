package com.xzp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzp.pojo.dto.SaveAnswerDTO;
import com.xzp.pojo.po.*;
import com.xzp.pojo.vo.student.StudentQuestionVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * 学生考试服务
 *
 * @author 薛展鹏
 * @description 针对表【s_student_exam(学生考试表)】的数据库操作Service
 * @date 2023/03/28
 */
public interface StudentExamService extends IService<StudentExam> {
    
    Integer createStudentExam(Integer studentId, Integer examId);

    Exam getExam(Integer studentExamId);

    List<StudentQuestion> getStudentQuestionList(Integer studentExamId);

    List<List<StudentQuestionVO>> getStudentQuestionVOListList(List<StudentQuestion> studentQuestionList);

    PaperQuestion getPaperQuestion(Integer paperId, Integer questionId);

    List<Option> getOptions(Integer questionId);

    boolean updateAnswer(SaveAnswerDTO saveAnswerDTO);

    BigDecimal checkAnswers(Integer studentExamId);

    StudentOption getStudentOption(Integer studentQuestionId, int optionId);

    boolean onlyHasObject(Integer studentExamId);

    List<StudentExam> getUserAndScore();

    StudentExam getPassPercentageData();

    List<StudentExam> perstuQualify();

}
