package com.xzp.service;

import java.util.List;
import java.util.Map;

/**
 * 数据视图服务
 * 时间未到，资格未够，继续努力！
 *
 * @author 薛展鹏
 * @Version 1.0
 * @date 2023/03/29
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
