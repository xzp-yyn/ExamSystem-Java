package com.xzp.other.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 时间未到，资格未够，继续努力！
 *
 * @Author xuezhanpeng
 * @Date 2023/3/26 9:34
 * @Version 1.0
 */
@Aspect
@Component
@Order(1)
public class ViewCountAop {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    private String VIEW_KEY="viewcount";
    private static AtomicInteger atomicInteger=new AtomicInteger(1);

    @Pointcut("@annotation(com.xzp.other.anno.ViewCountAnnotion)")
    public void pointExpression() {

    }
    @AfterReturning("pointExpression()")
    public void viewadd(){
        Boolean absent = redisTemplate.opsForValue().setIfAbsent(VIEW_KEY, atomicInteger.intValue());
        if(!absent){
            atomicInteger.set((Integer) redisTemplate.opsForValue().get(VIEW_KEY));
            redisTemplate.opsForValue().set(VIEW_KEY,atomicInteger.addAndGet(1));
        }

    }
}
