package com.xzp.pojo.dto;

import com.xzp.pojo.enums.TypeEnum;
import lombok.Data;

/**
 * 查询问题dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/28
 */
@Data
public class QueryQuestionDTO {

    private Integer repoId;

    private Integer chapterId;

    private TypeEnum type;

    private String content;

}
