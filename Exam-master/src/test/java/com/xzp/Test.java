package com.xzp;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.xzp.pojo.po.StudentExam;
import com.xzp.service.DataViewService;
import com.xzp.service.PaperService;
import com.xzp.service.StudentExamService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 时间未到，资格未够，继续努力！
 *
 * @Author xuezhanpeng
 * @Date 2023/3/26 10:19
 * @Version 1.0
 */
@SpringBootTest(classes = ExamApiApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private StudentExamService studentExamService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private DataViewService dataViewService;

   @org.junit.Test
   public void test1(){
        Set<String> keys = redisTemplate.keys("token:*");
       System.out.println(Arrays.toString(keys.toArray()));
    }

    @org.junit.Test
    public void test2(){
//        long count = paperService.count();
//        System.out.println(count);
        String start="2023-01-13 24:00:00";
        Date dateTime = DateUtil.parse(start);
        Date end = DateUtil.date();
        long l = DateUtil.between(dateTime, end, DateUnit.HOUR);
        System.out.println(l);
    }

    @org.junit.Test
    public void test3(){
        List<StudentExam> andScore = studentExamService.getUserAndScore();
        System.out.println(Arrays.toString(andScore.toArray()));
    }

    @org.junit.Test
    public void test4(){
        List<Map<String, Object>> percentage = dataViewService.perstuQualify();
        System.out.println(percentage);

    }



}
