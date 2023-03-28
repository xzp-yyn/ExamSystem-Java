package com.xzp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzp.pojo.po.Exam;
import org.springframework.stereotype.Repository;


/**
 * 考试映射器
 * 针对表【t_exam(考试表)】的数据库操作Mapper
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface ExamMapper extends BaseMapper<Exam> {

}




