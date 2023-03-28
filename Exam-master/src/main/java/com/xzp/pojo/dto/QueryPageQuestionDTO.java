package com.xzp.pojo.dto;

import com.xzp.pojo.enums.TypeEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 查询页面问题dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/28
 */
@Data
public class QueryPageQuestionDTO {

    @NotBlank(message = "页码不能为空")
    private Integer page;

    @NotBlank(message = "每页大小不能为空")
    private Integer limit;

    private Integer repoId;

    private Integer chapterId;

    private TypeEnum type;

    private String content;

    private List<Integer> excludeIdList;

}
