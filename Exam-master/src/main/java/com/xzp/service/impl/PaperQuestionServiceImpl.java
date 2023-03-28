package com.xzp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzp.mapper.PaperQuestionMapper;
import com.xzp.pojo.po.PaperQuestion;
import com.xzp.service.PaperQuestionService;
import org.springframework.stereotype.Service;

/**
 * 论文问题服务impl
 *
 * @author 薛展鹏
 * @description 针对表【t_paper_question(试卷题目表)】的数据库操作Service实现
 * @date 2023/03/28
 */
@Service
public class PaperQuestionServiceImpl extends ServiceImpl<PaperQuestionMapper, PaperQuestion>
    implements PaperQuestionService{

}




