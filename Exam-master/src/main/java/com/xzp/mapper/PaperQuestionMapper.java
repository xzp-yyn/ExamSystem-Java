package com.xzp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzp.pojo.po.PaperQuestion;
import org.springframework.stereotype.Repository;


/**
 * 试卷问题映射器
 *  针对表【t_paper_question(试卷题目表)】的数据库操作Mapper
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface PaperQuestionMapper extends BaseMapper<PaperQuestion> {

}




