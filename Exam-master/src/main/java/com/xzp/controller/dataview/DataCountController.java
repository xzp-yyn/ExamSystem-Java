package com.xzp.controller.dataview;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.xzp.mapper.ExamMapper;
import com.xzp.other.result.BaseResult;
import com.xzp.pojo.po.User;
import com.xzp.service.DataViewService;
import com.xzp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

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

    @Autowired
    private UserService userService;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private ThreadPoolExecutor executor;

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
        List<Map<String, Object>> list = null;
        try {
            list = executor.submit(new Callable<List<Map<String, Object>>>() {
                @Override
                public List<Map<String, Object>> call() throws Exception {
                    return dataViewService.Scoreranking();
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return BaseResult.successData(list);
    }

    @GetMapping("/question_percentage")
    public BaseResult question_percentage(){
        List<Map<String, Object>> list=null;
        try {
             list = executor.submit(new Callable<List<Map<String, Object>>>() {
                @Override
                public List<Map<String, Object>> call() throws Exception {
                    return dataViewService.getQuestionPercen();
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return BaseResult.successData(list);
    }
    @GetMapping("/stuqueRanking")
    public BaseResult stuQuesCount(){
        List<Map<String, Object>> list=null;

        try {
            list = executor.submit(new Callable<List<Map<String, Object>>>() {
                @Override
                public List<Map<String, Object>> call() throws Exception {
                    return dataViewService.getStuQuesRanking();
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return BaseResult.successData(list);
    }

    @GetMapping("/passingPercentage")
    public BaseResult passingPercentage(){

        return BaseResult.successData(dataViewService.getPassPercentage());
    }

    @GetMapping("/perstuPercentage")
    public BaseResult perstuPercentage(){
        List<Map<String, Object>> reference=null;
        try {
            reference=executor.submit(new Callable<List<Map<String, Object>>>() {
                @Override
                public List<Map<String, Object>> call() throws Exception {
                    return dataViewService.perstuQualify();
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return BaseResult.successData(reference);
    }

    @GetMapping("/stuexamdata/{token}")
    public BaseResult stuExamData(@PathVariable("token") String token){
        User user = userService.redisGetUser(token);
        Map<String, Object> hashMap = null;
        try {
            hashMap = executor.submit(new Callable<Map<String, Object>>() {
                @Override
                public Map<String, Object> call() throws Exception {
                    return dataViewService.getStuExamDataById(user.getId());
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return BaseResult.successData(hashMap);
    }

    @GetMapping("/stuExamCount/{token}")
    public BaseResult stuExamCount(@PathVariable("token") String token){
        Integer id = userService.redisGetUser(token).getId();
        return BaseResult.successData(dataViewService.getStuExamCount(id));
    }

    @GetMapping("/examRanking")
    public BaseResult getStuExamRanking(){
        List<List<String>> result=null;
        try {
            result = executor.submit(new Callable<List<List<String>>>() {
                @Override
                public List<List<String>> call() throws Exception {
                    return dataViewService.getStuExamRanking();
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return BaseResult.successData(result);
    }

    @GetMapping("/getMyExamCount/{token}")
    public BaseResult getMyExamCount(@PathVariable("token") String token){
        Integer id = userService.redisGetUser(token).getId();
        return BaseResult.successData(dataViewService.getMyExamCount(id));
    }
    @GetMapping("/wrongCount/{token}")
    public BaseResult getwrongCount(@PathVariable String token){
        Integer id = userService.redisGetUser(token).getId();
        return BaseResult.successData( dataViewService.getWrongCount(id));
    }

    @GetMapping("/examNames")
    public BaseResult examNames(){
        List<String> strings = examMapper.getallName();
        return BaseResult.successData(strings);
    }
    @GetMapping("/examPassPercen/{name}")
    public BaseResult examPassPercen(@PathVariable String name){
        return BaseResult.successData( dataViewService.examPassPercen(name));
    }

}
