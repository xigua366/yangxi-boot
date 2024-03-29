package com.yangxi.boot.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangxi.boot.framework.core.ObjectMapperImpl;
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

}