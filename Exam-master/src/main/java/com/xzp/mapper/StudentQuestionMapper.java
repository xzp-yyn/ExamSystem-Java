package com.xzp.mapper;

import com.xzp.pojo.po.StudentQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzp.pojo.vo.student.StudentQuestionVO;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 学生问题映射器
 *  针对表【s_student_question(学生答题表)】的数据库操作Mapper
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface StudentQuestionMapper extends BaseMapper<StudentQuestion> {

    List<StudentQuestionVO> getQuesPercen();

}




