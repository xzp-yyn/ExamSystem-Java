package com.xzp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzp.pojo.po.Option;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 选择映射器
 *  针对表【t_option(题目选项表)】的数据库操作Mapper
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface OptionMapper extends BaseMapper<Option> {
    List<Option> selectByQuestionId(@Param("questionId") Integer questionId);
}




