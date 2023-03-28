package com.xzp.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 查询页面用户dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/28
 */
@Data
public class QueryPageUserDTO {

    @NotBlank(message = "页码不能为空")
    private Integer page;

    @NotBlank(message = "每页大小不能为空")
    private Integer limit;

    private String username;

}
