package com.zhangbin.jpa.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * mark
 *
 * @Author: zhangbin
 * @Date: 2019-01-21 21:36
 * @Version 1.0
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //登录不拦截
        if (request.getRequestURL().equals("/user/login") || request.getRequestURL().equals("/user/login_view")) {
            return true;
        }

        //验证session是否存在
        Object obj = request.getSession().getAttribute("_session_user");

        if (obj == null) {
            response.sendRedirect("/user/login_view");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
