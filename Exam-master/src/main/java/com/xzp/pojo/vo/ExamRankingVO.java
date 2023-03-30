package com.xzp.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 时间未到，资格未够，继续努力！
 *
 * @Author xuezhanpeng
 * @Date 2023/3/30 16:05
 * @Version 1.0
 */
@Data
public class ExamRankingVO implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 考试名称
     */
    private String name;

    /**
     * 题目数量
     */
    private Integer questionCount;

    /**
     * 及格分数
     */
    private Integer qualifyScore;

}
