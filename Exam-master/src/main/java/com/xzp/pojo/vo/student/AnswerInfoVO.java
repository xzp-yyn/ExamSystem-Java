package com.xzp.pojo.vo.student;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 信息回答签证官
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/28
 */
@Data
public class AnswerInfoVO {

    /**
     * 学生考试问题id
     */
    Integer studentQuestionId;

    /**
     * 您的答案
     */
    String yourAnswer;

    /**
     * 是否正确
     */
    Integer isRight;

    /**
     * 得分
     */
    BigDecimal gotScore;

}
