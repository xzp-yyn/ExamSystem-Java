package com.xzp.controller.admin;

import com.xzp.other.result.BaseResult;
import com.xzp.other.result.PageResult;
import com.xzp.pojo.po.Chapter;
import com.xzp.pojo.vo.ChapterVO;
import com.xzp.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 管理章控制器
 *
 * @author 薛展鹏
 * @date 2023/03/21
 */
@RestController
@RequestMapping("/admin/chapter")
public class AdminChapterController {

    @Autowired
    ChapterService chapterService;

    /**
     * 查询所有
     * @return 对象列表
     */
    @GetMapping(value = "/queryChapters")
    public PageResult queryChapters(Integer repoId){
        List<ChapterVO> chapterVOS =  chapterService.getChapterVOS(repoId);
        return PageResult.success((long) chapterVOS.size(), chapterVOS);
    }

    /**
     * 保存全部
     * @param chapters
     * @return
     */
    @PostMapping(value = "/saveChapters")
    public BaseResult saveChapters(@RequestBody List<Chapter> chapters){
        return BaseResult.boolResult(chapterService.saveChapters(chapters));
    }

}
