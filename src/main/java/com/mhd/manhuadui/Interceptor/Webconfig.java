package com.mhd.manhuadui.Interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class Webconfig implements WebMvcConfigurer {
          @Override
          public void addInterceptors(InterceptorRegistry registry) {
              registry.addInterceptor(new AdminInterceptor())
                      .addPathPatterns("/admin/**")
                      .excludePathPatterns("/admin")
                      .excludePathPatterns("/admin/logincheck");
          }
          @Override
          public void addViewControllers(ViewControllerRegistry registry) {
              registry.addViewController("admin/main.html").setViewName("admin/index");
              registry.addViewController("/").setViewName("Index");
          }
}
