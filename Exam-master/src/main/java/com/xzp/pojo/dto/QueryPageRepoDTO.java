package com.xzp.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 回购dto查询页面
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/28
 */
@Data
public class QueryPageRepoDTO {

    @NotBlank(message = "页码不能为空")
    private Integer page;

    @NotBlank(message = "每页大小不能为空")
    private Integer limit;

    private String name;

}
