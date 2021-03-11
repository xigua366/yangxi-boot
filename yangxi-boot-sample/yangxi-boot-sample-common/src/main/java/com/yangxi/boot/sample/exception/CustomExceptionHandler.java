package com.yangxi.boot.sample.exception;

import com.yangxi.boot.sample.exception.MyException;
import com.yangxi.boot.sample.utils.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * @author yangxi
 **/
@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {

        if(e instanceof MyException) {
            log.error("[ 业务异常 ]", e);
            MyException myException = (MyException) e;
            return JsonData.buildError(myException.getCode(), myException.getMsg());
        } else {
            log.error("[ 系统异常 ]", e);
            return JsonData.buildError("全局异常，未知错误");
        }

    }

}