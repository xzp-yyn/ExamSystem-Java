package com.xzp.pojo.dto;

import com.xzp.pojo.po.StudentOption;
import lombok.Data;

import java.util.List;

/**
 * 保存答案dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/28
 */
@Data
public class SaveAnswerDTO {

    /**
     * 学生问题id
     */
    Integer studentQuestionId;

    /**
     * 回答
     */
    String answer;

    /**
     * 学生选项
     */
    List<StudentOption> studentOptions;

}
