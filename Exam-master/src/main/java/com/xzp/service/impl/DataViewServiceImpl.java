package com.xzp.service.impl;

import com.xzp.pojo.po.Question;
import com.xzp.pojo.po.StudentExam;
import com.xzp.pojo.po.User;
import com.xzp.pojo.vo.student.StudentQuestionVO;
import com.xzp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 时间未到，资格未够，继续努力！
 *
 * @Author xuezhanpeng
 * @Date 2023/3/26 9:27
 * @Version 1.0
 */
@Service
public class DataViewServiceImpl implements DataViewService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RepoService repoService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private StudentExamService studentExamService;

    @Autowired
    private StudentQuestionService studentQuestionService;



    @Autowired
    private PaperService paperService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExamService examService;

    private String VIEW_KEY="viewcount";

    private String ONLINE_PATTERN="token:*";


    @Override
    public Integer viewCount() {
        Integer count = redisTemplate.opsForValue().get(VIEW_KEY)==null?0:(Integer) redisTemplate.opsForValue().get(VIEW_KEY);
        return count;
    }

    @Override
    public Integer onlinePerson() {
        Integer onlineCount=redisTemplate.keys(ONLINE_PATTERN)==null?Integer.valueOf(0):redisTemplate.keys(ONLINE_PATTERN).size();
        return onlineCount;
    }

    @Override
    public long repo() {
        long count = repoService.count();
        return count;
    }

    @Override
    public long questionCount() {
        long count = questionService.count();
        return count;
    }

    @Override
    public long paperCount() {
        long count = paperService.count();
        return count;
    }

    @Override
    public long examCount() {
        long count = examService.count();
        return count;
    }

    @Override
    public List<Map<String, Object>> Scoreranking() {
        List<Map<String, Object>> maps = new ArrayList<>();
        List<StudentExam> studentExam=studentExamService.getUserAndScore();
        studentExam.stream().forEach(item->{
            ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>();
            User user = userService.getById(item.getStudentId());
            hashMap.put("name",user.getUsername());
            hashMap.put("value",item.getScore());
            maps.add(hashMap);
        });
        return maps;
    }

    @Override
    public List<Map<String, Object>> getQuestionPercen() {
        List<Map<String, Object>> maps = new ArrayList<>();
        List<StudentQuestionVO> questionVOS= studentQuestionService.getQuestionPercen();
        questionVOS.stream().forEach(item->{
            ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>();
            Question question = questionService.getById(item.getQuestionId());
            hashMap.put("name",question.getContent());
            hashMap.put("value",item.getCounts());
            maps.add(hashMap);
        });
        return maps;
    }
}
