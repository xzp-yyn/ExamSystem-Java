package com.xzp.pojo.dto;

import com.xzp.pojo.po.Option;
import com.xzp.pojo.po.Question;
import lombok.Data;

/**
 * @Author: 王鹏
 * @Date: 2022/03/27/13:34
 * @Description:
 */
@Data
public class SaveQuestionDTO {

    private Question question;

    private Option[] option;

}
