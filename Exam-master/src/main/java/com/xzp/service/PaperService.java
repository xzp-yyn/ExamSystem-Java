package com.xzp.service;

import com.xzp.pojo.dto.SavePaperDTO;
import com.xzp.pojo.po.Paper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzp.pojo.vo.PaperInfoVO;
import com.xzp.pojo.vo.PaperQuestionVO;
import com.xzp.pojo.vo.PaperVO;

import java.util.List;

/**
* @author wangpeng
* @description 针对表【t_paper(试卷表)】的数据库操作Service
* @createDate 2022-03-28 11:25:29
*/
public interface PaperService extends IService<Paper> {

    void savePaper(SavePaperDTO savePaperDTO);

    PaperVO getPaperVO(Integer paperId);
    List<List<PaperQuestionVO>> getPaperQuestionVOListList(Integer paperId);

    PaperInfoVO getPaper(Integer paperId);

    void removePaper(Paper paper);
}
