package com.xzp.mapper;

import com.xzp.pojo.po.Exam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 考试映射器
 * 针对表【t_exam(考试表)】的数据库操作Mapper
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface ExamMapper extends BaseMapper<Exam> {

    String getNameByID(@Param("id") Integer id);

    List<String>  getallName();

}




