package com.xzp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzp.pojo.dto.QueryPageQuestionDTO;
import com.xzp.pojo.dto.QueryQuestionDTO;
import com.xzp.pojo.dto.SaveQuestionDTO;
import com.xzp.pojo.po.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzp.pojo.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 问题服务
 *
 * @author 薛展鹏
 * @description 针对表【t_question(题目表)】的数据库操作Service
 * @date 2023/03/29
 */
public interface QuestionService extends IService<Question> {

    Page<QuestionVO> getQuestionVOPage(QueryPageQuestionDTO queryPageQuestionDTO);

    boolean saveQuestionAndAnswer(SaveQuestionDTO saveQuestionDTO);

    void deleteQuestion(Question question);

    List<QuestionVO> getRandomQuestion(Integer repoId, Integer chapterId, Integer quantity, Integer typeId, List<Integer> excludeIdList);

    String exportExcel(QueryQuestionDTO queryQuestionDTO, HttpServletRequest req) throws Exception;

    void importExcel(String path);

}
