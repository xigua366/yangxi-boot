package com.yangxi.boot.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangxi.boot.common.core.ObjectMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author yangxi
 * @version 1.0
 */
@Configuration
public class DefaultWebAutoConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapperImpl();
    }

      // 目前没有实现逻辑，先注释掉
//    @Bean
//    public DefaultWebMvcConfigurer defaultWebMvcConfigurer() {
//        return new DefaultWebMvcConfigurer();
//    }
}