package com.xzp.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.xzp.pojo.po.Option;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


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




