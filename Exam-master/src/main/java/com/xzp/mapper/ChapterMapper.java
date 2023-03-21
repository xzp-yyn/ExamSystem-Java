package com.xzp.mapper;

import com.xzp.pojo.po.Chapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


/**
 * 章映射器
 * 针对表【t_chapter(章节表)】的数据库操作Mapper
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Repository
public interface ChapterMapper extends BaseMapper<Chapter> {

}




