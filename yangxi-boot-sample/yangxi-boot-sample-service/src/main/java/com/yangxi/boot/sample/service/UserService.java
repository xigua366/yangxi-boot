package com.yangxi.boot.sample.service;

import com.yangxi.boot.common.core.JsonData;
import com.yangxi.boot.sample.domain.request.LoginRequest;
import com.yangxi.boot.sample.domain.request.RegisterRequest;

/**
 * 用户管理服务Service接口
 * @author yangxi
 */
public interface UserService {

    /**
     * 新增用户
     * @param registerRequest
     * @return
     */
    JsonData register(RegisterRequest registerRequest);

    /**
     * 登录接口
     * @param loginRequest
     * @return token 令牌
     */
    JsonData login(LoginRequest loginRequest);
}
