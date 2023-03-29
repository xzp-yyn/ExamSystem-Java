package com.xzp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzp.pojo.enums.TypeEnum;
import com.xzp.pojo.po.Question;
import com.xzp.pojo.vo.QuestionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 问题映射器
 *  针对表【t_question(题目表)】的数据库操作Mapper
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface QuestionMapper extends BaseMapper<Question> {

    Page<QuestionVO> getQuestionVOPage(
            Page<QuestionVO> page,
            @Param("repoId") Integer repoId,
            @Param("chapterId") Integer chapterId,
            @Param("type") TypeEnum type,
            @Param("content") String content,
            @Param("list") List<Integer> excludeIdList);

    List<QuestionVO> getQuestionVO(
            @Param("repoId") Integer repoId,
            @Param("chapterId") Integer chapterId,
            @Param("type") TypeEnum type,
            @Param("content") String content);

    List<QuestionVO> selectQuestionsByRandom(
            @Param("repoId") Integer repoId,
            @Param("chapterId") Integer chapterId,
            @Param("quantity") Integer quantity,
            @Param("typeId") Integer typeId,
            @Param("list") List<Integer> excludeIdList);
}
