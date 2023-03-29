package com.xzp.pojo.dto;

import com.xzp.pojo.po.Paper;
import com.xzp.pojo.po.PaperQuestion;
import lombok.Data;

import java.util.List;

/**
 * 节省纸张dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Data
public class SavePaperDTO {

    private Paper paper;

    private List<List<PaperQuestion>> paperQuestionListList;

}
