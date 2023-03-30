package com.xzp.mapper;

import com.xzp.pojo.po.Paper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzp.pojo.vo.ExamRankingVO;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 纸映射器
 *
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface PaperMapper extends BaseMapper<Paper> {

    List<ExamRankingVO> getExamRanking();

}

