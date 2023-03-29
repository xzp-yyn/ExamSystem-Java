package com.xzp.other.interceptor;

import com.xzp.other.utils.ResponseJson;
import com.xzp.pojo.po.User;
import com.xzp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户拦截器
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行预请求
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) return true;
        // 获取请求中的Token
        String token = request.getHeader("X-Token");
        if (token == null) {
            ResponseJson.errorMsg(response, "身份认证失败，请重新登录！");
            return false;
        }
        // 根据token取用户
        User user = userService.redisGetUser(token);
        // user 不为空放行，否则拦截
        if (user == null) {
            ResponseJson.errorMsg(response, "身份认证失败，请重新登录！");
            return false;
        }
        return true;
    }
}
