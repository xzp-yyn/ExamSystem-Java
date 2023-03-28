package com.xzp.pojo.vo.student;

import com.xzp.pojo.enums.TypeEnum;
import com.xzp.pojo.po.Option;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 学生考试签证官问题
 *
 * @author 薛展鹏
 * @Description: 发给学生考试界面的题目，不能包含敏感信息
 * @date 2023/03/28
 */
@Data
public class StudentExamQuestionVO implements Serializable {

    /**
     * 题目id
     */
    private Integer questionId;

    /**
     * 排序号
     */
    private Integer orderNum;

    /**
     * 题目类型
     */
    private TypeEnum type;

    /**
     * 题目分数
     */
    private BigDecimal score;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 题目图片
     */
    private String image;

    /**
     * 选项
     */
    private List<Option> options;
}
