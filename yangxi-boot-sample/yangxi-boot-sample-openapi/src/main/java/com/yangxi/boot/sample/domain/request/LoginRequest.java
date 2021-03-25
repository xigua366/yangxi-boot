package com.yangxi.boot.sample.domain.request;

import com.yangxi.boot.common.domain.request.BaseRequest;

/**
 * 登录 request
 */
public class LoginRequest extends BaseRequest {

    private String phone;

    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
