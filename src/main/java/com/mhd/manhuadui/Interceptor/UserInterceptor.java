package com.mhd.manhuadui.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户未登录拦截
 */
public class UserInterceptor extends HandlerInterceptorAdapter{
       public boolean preHandle(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler) throws Exception{
            if(request.getSession().getAttribute("user")==null) {
                 response.sendRedirect("/login");
                 return false;
            } else  {
                return true;
            }
       }

}
