package com.xzp.other.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzp.other.result.BaseResult;

import javax.servlet.http.HttpServletResponse;

/**
 * json响应
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/28
 */
public class ResponseJson {

    public static void errorMsg(HttpServletResponse response, String msg) throws Exception {
        BaseResult baseResult = BaseResult.errorMsg(msg);
        String json = new ObjectMapper().writeValueAsString(baseResult);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }

}
