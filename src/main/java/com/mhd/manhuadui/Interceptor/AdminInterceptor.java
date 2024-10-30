package com.mhd.manhuadui.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台拦截
 * create time 2020-02-01
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

          @Override
          public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
              if(request.getSession().getAttribute("admin")==null) {
                  response.sendRedirect("/admin");
                  return false;
              }
               else  {
                  return true;
              }
          }

}
