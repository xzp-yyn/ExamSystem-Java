package com.xzp.pojo.enums;

/**

 * @Description:
 */

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 枚举类型
 *
 * @author 薛展鹏
 * @date 2023/03/29
 */
@Getter
@AllArgsConstructor
public enum TypeEnum {

        SINGLE(0, "单选题"),
        MULTI(1, "多选题"),
        JUDGE(2, "判断题"),
        BLANK(3, "填空题"),
        WRITE(4, "简答题");

        @EnumValue
        private Integer type;

        @JsonValue
        private String typeName;

}
