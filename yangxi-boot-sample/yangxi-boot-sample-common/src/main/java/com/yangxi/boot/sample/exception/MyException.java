package com.yangxi.boot.sample.exception;

import java.text.MessageFormat;

/**
 * 自定义业务异常
 * @author yangxi
 * @version 1.0
 */
public class MyException extends RuntimeException {

    private int code = -1;

    private String msg;

    public MyException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyException(BizCodeEnum bizCodeEnum) {
        super(bizCodeEnum.getMessage());
        this.code = bizCodeEnum.getCode();
        this.msg = bizCodeEnum.getMessage();
    }

    public MyException(int code, String msg, Object... arguments) {
        super(MessageFormat.format(msg, arguments));
        this.code = code;
        this.msg = MessageFormat.format(msg, arguments);
    }

    public MyException(BizCodeEnum bizCodeEnum, Object... arguments) {
        super(MessageFormat.format(bizCodeEnum.getMessage(), arguments));
        this.code = bizCodeEnum.getCode();
        this.msg = MessageFormat.format(bizCodeEnum.getMessage(), arguments);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;

    }
}