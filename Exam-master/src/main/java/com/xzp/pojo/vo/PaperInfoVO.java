package com.xzp.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * 论文信息签证官
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Data
public class PaperInfoVO {

    private PaperVO paper;

    private List<List<PaperQuestionVO>> paperQuestionListList;

}
