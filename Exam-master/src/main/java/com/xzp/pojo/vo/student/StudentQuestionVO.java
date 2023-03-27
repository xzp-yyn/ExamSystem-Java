package com.xzp.pojo.vo.student;

import com.xzp.pojo.enums.TypeEnum;
import com.xzp.pojo.po.StudentOption;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 学生签证官
 *
 * @author 薛展鹏
 * @date 2023/03/26
 */
@Data
public class StudentQuestionVO implements Serializable {

    /**
     * 回答id
     */
    private Integer id;

    /**
     * 题目id
     */
    private Integer questionId;

    /**
     * 题目类型
     */
    private TypeEnum type;

    /**
     * 题目分数
     */
    private BigDecimal score;

    /**
     * 题目排序
     */
    private Integer orderNum;

    /**
     * 回答
     */
    private String Answer;

    /**
     * 是否已答
     */
    private Integer isAnswered;

    /**
     * 选项信息
     */
    private List<StudentOption> options;

    /**
     * 出错问题数量
     */
    private Integer counts;
}
