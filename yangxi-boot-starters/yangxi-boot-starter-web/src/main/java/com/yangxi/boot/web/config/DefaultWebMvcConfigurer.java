package com.yangxi.boot.web.config;

import com.yangxi.boot.web.interceptor.DefaultWebMvcHandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 默认的web mvc相关配置
 * @author yangxi
 * @version 1.0
 */
public class DefaultWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO
        registry.addInterceptor(new DefaultWebMvcHandlerInterceptor()).addPathPatterns("/**");
    }
}