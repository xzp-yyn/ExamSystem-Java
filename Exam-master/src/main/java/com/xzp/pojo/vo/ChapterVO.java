package com.xzp.pojo.vo;

import com.xzp.pojo.po.Chapter;
import lombok.Data;

/**
 * 签证官章
 *
 * @author 薛展鹏
 * @Description: 章节的VO，多一个题目数量字段
 * @date 2023/03/29
 */
@Data
public class ChapterVO extends Chapter {

    /**
     * 题目数量
     */
    private Long questionCount;

}
