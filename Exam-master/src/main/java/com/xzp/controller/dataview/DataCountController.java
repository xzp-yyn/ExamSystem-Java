package com.xzp.controller.dataview;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.xzp.other.result.BaseResult;
import com.xzp.service.DataViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 时间未到，资格未够，继续努力！
 *
 * @Author xuezhanpeng
 * @Date 2023/3/26 10:43
 * @Version 1.0
 */
@RestController
@RequestMapping("/data")
public class DataCountController {
    @Autowired
    private DataViewService dataViewService;

    @GetMapping("/commonview")
    public BaseResult getviewResylt(){
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("viewcount",dataViewService.viewCount());
        String start="2023-01-13 24:00:00";
        Date dateTime = DateUtil.parse(start);
        Date end = DateUtil.date();
        long l = DateUtil.between(dateTime, end, DateUnit.HOUR);
        map.put("runtime",l);
        map.put("onlineperson",dataViewService.onlinePerson());
        map.put("repocount",dataViewService.repo());
        map.put("examcount",dataViewService.examCount());
        map.put("papercount",dataViewService.paperCount());
        map.put("questioncount",dataViewService.questionCount());
        return BaseResult.successData(map);
    }

    @GetMapping("/scoreranking")
    public BaseResult scorerankingData(){
        List<Map<String, Object>> maps = dataViewService.Scoreranking();
        return BaseResult.successData(maps);
    }

    @GetMapping("/question_percentage")
    public BaseResult question_percentage(){
        List<Map<String, Object>> maps = dataViewService.getQuestionPercen();
        return BaseResult.successData(maps);
    }



}
