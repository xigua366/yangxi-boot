package com.yangxi.boot.sample.controller;

import com.yangxi.boot.common.core.JsonData;
import com.yangxi.boot.sample.domain.request.LoginRequest;
import com.yangxi.boot.sample.domain.request.RegisterRequest;
import com.yangxi.boot.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员用户管理
 * @author yangxi
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param registerRequest
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }

    /**
     * 登录接口
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

}