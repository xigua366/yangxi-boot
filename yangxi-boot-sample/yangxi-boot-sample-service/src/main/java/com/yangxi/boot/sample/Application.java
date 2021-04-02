package com.yangxi.boot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 面向C端会员的服务
 *
 * 登录采用 jwt + spring mvc拦截器实现
 * 不做rbac的权限管理功能
 *
 * @author yangxi
 * @version 1.0
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}