package com.xzp.service;

import com.xzp.pojo.po.StudentExam;

import java.util.List;
import java.util.Map;

/**
 * 时间未到，资格未够，继续努力！
 *
 * @Author xuezhanpeng
 * @Date 2023/3/26 9:26
 * @Version 1.0
 */
public interface DataViewService {

    Integer viewCount();

    Integer onlinePerson();

    long repo();

    long questionCount();

    long paperCount();

    long examCount();

    List<Map<String,Object>> Scoreranking();


    List<Map<String, Object>> getQuestionPercen();

    List<Map<String,Object>> getStuQuesRanking();

    Integer getPassPercentage();

    List<Map<String,Object>> perstuQualify();


}
