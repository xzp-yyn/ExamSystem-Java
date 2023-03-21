package com.xzp.other.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzp.other.result.BaseResult;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 王鹏
 * @Date: 2022/09/18/21:45
 * @Description:
 */
public class ResponseJson {

    public static void errorMsg(HttpServletResponse response, String msg) throws Exception {
        BaseResult baseResult = BaseResult.errorMsg(msg);
        String json = new ObjectMapper().writeValueAsString(baseResult);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }

}
