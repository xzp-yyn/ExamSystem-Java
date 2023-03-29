package com.xzp.pojo.vo;

import com.xzp.pojo.po.Option;
import com.xzp.pojo.po.Question;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 签证官问题
 * 题目表VO
 *
 * @author 薛展鹏
 * @TableName t_question
 * @date 2023/03/29
 */
@Data
public class QuestionVO extends Question implements Serializable {
    /**
     * 选项
     */
    private List<Option> options;

    /**
     * 题库名
     */
    private String repoName;

    /**
     * 章节名
     */
    private String chapterName;
}
