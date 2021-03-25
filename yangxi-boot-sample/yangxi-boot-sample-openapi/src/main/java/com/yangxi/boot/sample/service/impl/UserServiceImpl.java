package com.yangxi.boot.sample.service.impl;

import com.yangxi.boot.sample.domain.request.RegisterRequest;
import com.yangxi.boot.sample.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author yangxi
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public int save(RegisterRequest registerRequest) {

        // 注册逻辑待实现 TODO

        return 1;
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {

        // 验证手机号码+密码的逻辑待实现 TODO

        String token = "yxeyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5eCIsImhlYWRfaW1nIjoiaHR0cHM6Ly94ZC12aWRlby1wYy1pbWcub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tL3hkY2xhc3NfcHJvL2RlZmF1bHQvaGVhZF9pbWcvMTIuanBlZyIsImlkIjo4LCJuYW1lIjoieWFuZ3hpIiwiaWF0IjoxNjEzOTgzOTY0LCJleHAiOjE2MTM5ODQ1NjR9.5XqpH7oCi1gGRo5oE0bCqLDW4tgNDSsFWCVzqE1d_Bs";
        return token;
    }
}