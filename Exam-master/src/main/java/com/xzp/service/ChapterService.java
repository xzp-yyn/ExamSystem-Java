package com.xzp.service;

import com.xzp.pojo.po.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzp.pojo.vo.ChapterVO;

import java.util.List;

/**
 * 章服务
 *
 * @author 薛展鹏
 * @description 针对表【t_chapter(章节表)】的数据库操作Service
 * @date 2023/03/29
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVO> getChapterVOS(Integer repoId);

    Boolean saveChapters(List<Chapter> chapters);

}
