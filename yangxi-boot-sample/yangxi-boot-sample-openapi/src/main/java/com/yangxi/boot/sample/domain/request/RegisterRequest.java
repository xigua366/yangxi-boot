package com.yangxi.boot.sample.domain.request;

import com.yangxi.boot.common.domain.request.BaseRequest;

/**
 * 注册 request
 * @author yangxi
 * @version 1.0
 */
public class RegisterRequest extends BaseRequest {

    /**
     * 昵称
     */
    private String name;

    /**
     * 手机
     */
    private String phone;

    /**
     * 密码
     */
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}