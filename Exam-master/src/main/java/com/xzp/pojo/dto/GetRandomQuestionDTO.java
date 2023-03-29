package com.xzp.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * 得到随机问题dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Data
public class GetRandomQuestionDTO {

    Integer typeId;

    Integer repoId;

    Integer chapterId;

    Integer quantity;

    private List<Integer> excludeIdList;
}
