package com.xzp.pojo.vo.student;

import lombok.Data;

import java.io.Serializable;

/**
 * 时间未到，资格未够，继续努力！
 *
 * @Author xuezhanpeng
 * @Date 2023/3/31 17:15
 * @Version 1.0
 */
@Data
public class WrongCountVO implements Serializable {

    /**
     *  考试名称
     */
    private String name;
    /**
     * 考试ID
     */
    private Long studentExamId;
    /**
     * 错题数量
     */
    private Integer notQualify;
}
