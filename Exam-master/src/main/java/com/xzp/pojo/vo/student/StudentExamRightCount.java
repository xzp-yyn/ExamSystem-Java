package com.xzp.pojo.vo.student;

import lombok.Data;

import java.io.Serializable;

/**
 * 时间未到，资格未够，继续努力！
 *
 * @Author xuezhanpeng
 * @Date 2023/3/30 14:46
 * @Version 1.0
 */
@Data
public class StudentExamRightCount implements Serializable {

    /**
     * 试卷id
     */
    private Integer exam_id;

    /**
     * 考试对应ID
     */
    private Integer studentExamId;

    /**
     * 考试正确数量
     */
    private Integer sum;

    /**
     * 考试名称
     */
    private String exam_name;

}
