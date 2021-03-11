package ${package}.config;

import com.deepexi.util.config.Payload;
import com.deepexi.util.exception.ApplicationException;
import com.deepexi.util.exception.CommonExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * @author yangxi
 **/
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Payload<String> handle(Exception e){

        //是不是自定义异常
        if(e instanceof ApplicationException){

            ApplicationException exception = (ApplicationException) e;
            log.error("[业务异常]", exception);
            return new Payload<>(null, exception.getCode(), exception.getMessage());
        }else{
            log.error("[系统异常]", e);
            return new Payload<>(null, CommonExceptionCode.ERROR_CODE, "系统异常");
        }

    }

}