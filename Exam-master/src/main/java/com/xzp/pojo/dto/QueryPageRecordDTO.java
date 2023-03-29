package com.xzp.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 查询页面记录dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Data
public class QueryPageRecordDTO {

    @NotBlank(message = "页码不能为空")
    private Integer page;

    @NotBlank(message = "每页大小不能为空")
    private Integer limit;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 是否完成
     */
    private Integer isFinished;

    /**
     * 是否及格
     */
    private Integer isQualify;

    /**
     * 是否批改
     */
    private Integer isChecked;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

}
