package com.yangxi.boot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 面向运营管理端的api
 *
 * 登录采用 jwt + shiro框架实现
 * 需要做rbac的权限管理功能
 *
 * @author yangxi
 * @version 1.0
 */
@SpringBootApplication
public class AdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApiApplication.class, args);
    }
}