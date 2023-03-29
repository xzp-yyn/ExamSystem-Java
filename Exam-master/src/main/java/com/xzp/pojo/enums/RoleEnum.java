package com.xzp.pojo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 角色枚举
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Getter
@AllArgsConstructor
public enum RoleEnum {

    ADMIN(0, "管理员"),
    STUDENT(1, "学生");

    @EnumValue
    private Integer role;

    @JsonValue
    private String roleName;

}
