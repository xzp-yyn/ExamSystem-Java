package com.xzp.mapper;

import com.xzp.pojo.po.StudentExam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * 学生考试映射器
 *  针对表【s_student_exam(学生考试表)】的数据库操作Mapper
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface StudentExamMapper extends BaseMapper<StudentExam> {

    List<StudentExam> getUserAndScore();

    StudentExam getPassPercentageData();

    List<StudentExam> perstuQualify();

    StudentExam perStuExamData(@Param("id") Integer id);

    Integer getExamSum(@Param("id") Integer id);

    StudentExam getPassnumByName(@Param("name")String name);

}




