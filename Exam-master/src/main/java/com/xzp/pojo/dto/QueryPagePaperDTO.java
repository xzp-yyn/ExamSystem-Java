package com.xzp.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 查询页面纸dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Data
public class QueryPagePaperDTO {

    @NotBlank(message = "页码不能为空")
    private Integer page;

    @NotBlank(message = "每页大小不能为空")
    private Integer limit;

    private String name;

    private Integer creator;

}
