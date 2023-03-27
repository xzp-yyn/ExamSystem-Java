package com.xzp.service.impl;

import com.xzp.pojo.po.Question;
import com.xzp.pojo.po.StudentExam;
import com.xzp.pojo.po.StudentQuestion;
import com.xzp.pojo.po.User;
import com.xzp.pojo.vo.student.StudentQuestionVO;
import com.xzp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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

    @Override
    public List<Map<String,Object>> getStuQuesRanking(){
        List<Map<String, Object>> maps = new ArrayList<>();
        List<Map<String, Object>> finalNewMaps=new ArrayList<>();
        List<StudentQuestion> studentQuestions = studentQuestionService.getquestionCount();
        if(studentQuestions.size()>0){
            studentQuestions.stream().forEach(item->{
                String name = userService.getNameByExamId(item.getStudentExamId());
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name",name);
                hashMap.put("value",item.getCounts());
                maps.add(hashMap);
//                        maps.forEach(map -> {
//                            if (!map.containsValue(name) || maps.size() == 0) {
//                                Map<String, Object> hashMap = new ConcurrentHashMap<>();
//                                hashMap.put("name", name);
//                                hashMap.put("value", item.getCounts());
//                                maps.add(hashMap);
//                            } else {
//                                Integer value = (Integer) map.get("value");
//                                map.put("value", value + item.getCounts());
//                            }
//                        });
            });
            //遍历maps进行重复名称的数量相加
            for (int i = 0; i < maps.size(); i++) {
                if(finalNewMaps.size()==0){
                    finalNewMaps.add(maps.get(i));
                }else {
                    Map<String, Object> objectMap = maps.get(i);
                    for (int j = 0; j < finalNewMaps.size(); j++) {
                        if(objectMap.get("name").equals(finalNewMaps.get(j).get("name"))){
                                Integer value=(Integer) objectMap.get("value")+(Integer)finalNewMaps.get(j).get("value");
                                objectMap.put("value",value);
                                finalNewMaps.remove(j);
                        }
                    }
                    finalNewMaps.add(objectMap);
                }
            }
        }
        return finalNewMaps;
    }
    @Override
    public Integer getPassPercentage() {
        StudentExam studentExam = studentExamService.getPassPercentageData();
        DecimalFormat format = new DecimalFormat("##.00%");
        String per = format.format(studentExam.getQualify().doubleValue() / studentExam.getSum().doubleValue()).substring(0,2);
        return Integer.valueOf(per);
    }

    @Override
    public List<Map<String, Object>> perstuQualify() {
        List<Map<String, Object>> arrayList = new ArrayList<>();
        List<StudentExam> studentExams = studentExamService.perstuQualify();
        studentExams.stream().forEach(e->{
            String username = userService.getById(e.getStudentId()).getUsername();
            ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>();
            DecimalFormat format = new DecimalFormat("###.00%");
            String format1 = format.format(e.getQualify().doubleValue() / e.getSum().doubleValue());
            Integer percentage= Integer.valueOf(format1.substring(0,format1.indexOf('.')));
            hashMap.put("name",username);
            hashMap.put("value",percentage);
            arrayList.add(hashMap);
        });
        return arrayList;
    }
}
