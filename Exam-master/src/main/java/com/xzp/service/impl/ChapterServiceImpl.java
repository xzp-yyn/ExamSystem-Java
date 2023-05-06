package com.xzp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzp.mapper.QuestionMapper;
import com.xzp.other.anno.RemoveRedis;
import com.xzp.pojo.po.Chapter;
import com.xzp.pojo.po.Question;
import com.xzp.pojo.vo.ChapterVO;
import com.xzp.service.ChapterService;
import com.xzp.mapper.ChapterMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 章服务impl
 *
 * @author 薛展鹏
 * @description 针对表【t_chapter(章节表)】的数据库操作Service实现
 * @date 2023/03/29
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter>
    implements ChapterService{

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private QuestionMapper questionMapper;

    private static String chapter_key="getChapterVOS:";

    @Override
    public List<ChapterVO> getChapterVOS(Integer repoId) {
        if(redisTemplate.hasKey(chapter_key+repoId)){
            return (List<ChapterVO>) redisTemplate.opsForValue().get(chapter_key+repoId);
        }

        // 题库id相等
        QueryWrapper<Chapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(repoId != null, "repo_id", repoId);
        // 按照order_num升序排序
        queryWrapper.orderByAsc("order_num");
        List<Chapter> list = baseMapper.selectList(queryWrapper);
        // 整合VO
        List<ChapterVO> voList = new ArrayList<>();
        for (Chapter chapter : list) {
            ChapterVO chapterVO = new ChapterVO();
            // 复制相同属性
            BeanUtils.copyProperties(chapter, chapterVO);
            // 获得该章节的题目数量
            QueryWrapper<Question> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("chapter_id", chapter.getId());
            Long questionCount = questionMapper.selectCount(queryWrapper1);
            // 设置题目数量
            chapterVO.setQuestionCount(questionCount);
            // 添加列表
            voList.add(chapterVO);
        }
        redisTemplate.opsForValue().setIfAbsent(chapter_key+repoId,voList,10, TimeUnit.MINUTES);
        return voList;
    }

    @Override
    @Transactional
    public Boolean saveChapters(List<Chapter> chapters) {
        // 获取题库id
        Integer repoId = chapters.get(0).getRepoId();
        if (repoId == null) {
            throw new RuntimeException("没有题库id，不能添加章节");
        }

        // 给列表添加order_num，顺便检查题库id，添加到集合中
        int count = 0;
        for (Chapter cur : chapters) {
            cur.setOrderNum(++count);
        }

        // 删除当前题库的章节列表
        QueryWrapper<Chapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq( "repo_id", repoId);
        baseMapper.delete(queryWrapper);

        // 重新添加章节
        for (Chapter cur : chapters) {
            baseMapper.insert(cur);
        }


        return true;
    }
}
