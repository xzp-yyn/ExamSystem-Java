package com.xzp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzp.pojo.dto.QueryPageExamDTO;
import com.xzp.pojo.po.Exam;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 考试服务
 *
 * @author 薛展鹏
 * @description 针对表【t_exam(考试表)】的数据库操作Service
 * @date 2023/03/29
 */
public interface ExamService extends IService<Exam> {

    Page<Exam> getPage(QueryPageExamDTO queryPageExamDTO);

    void deleteExam(Exam exam);
}
