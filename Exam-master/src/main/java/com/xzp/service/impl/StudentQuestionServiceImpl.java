package com.xzp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzp.pojo.po.StudentQuestion;
import com.xzp.pojo.vo.student.StudentQuestionVO;
import com.xzp.service.StudentQuestionService;
import com.xzp.mapper.StudentQuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生服务impl
 *
 * @author 薛展鹏
 * @description 针对表【s_student_question(学生答题表)】的数据库操作Service实现
 * @date 2023/03/29
 */
@Service
public class StudentQuestionServiceImpl extends ServiceImpl<StudentQuestionMapper, StudentQuestion>
    implements StudentQuestionService{


    @Override
    public List<StudentQuestionVO> getQuestionPercen() {
        List<StudentQuestionVO> vos= baseMapper.getQuesPercen();
        return vos;
    }

    @Override
    public List<StudentQuestion> getquestionCount() {
        return baseMapper.getquestionCount();
    }
}




