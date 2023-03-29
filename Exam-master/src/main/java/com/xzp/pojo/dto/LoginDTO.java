package com.xzp.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录dto
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Data
public class LoginDTO {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 验证码的key
     */
    @NotBlank(message = "key不能为空")
    private String key;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String code;
}
