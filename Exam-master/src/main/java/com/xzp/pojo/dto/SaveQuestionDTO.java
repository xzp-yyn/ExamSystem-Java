package com.xzp.pojo.dto;

import com.xzp.pojo.po.Option;
import com.xzp.pojo.po.Question;
import lombok.Data;

/**
 * 保存问题dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Data
public class SaveQuestionDTO {

    private Question question;

    private Option[] option;

}
