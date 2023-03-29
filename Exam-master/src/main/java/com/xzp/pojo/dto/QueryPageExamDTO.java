package com.xzp.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 查询页面考试dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Data
public class QueryPageExamDTO {

    @NotBlank(message = "页码不能为空")
    private Integer page;

    @NotBlank(message = "每页大小不能为空")
    private Integer limit;

    /**
     * 考试名称
     */
    private String name;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}
