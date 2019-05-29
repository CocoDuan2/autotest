package com.xingxing.exception;

import com.google.common.base.Strings;
import entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class BaseExceptionHandler {

/*    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result error(RuntimeException e) {
        log.error("统一异常处理:",e);
        //log.error("统一异常处理:",e.getMessage());
        return new Result(false, StatusCode.ERROR, e.getMessage(),"");
    }*/

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result businessError(BusinessException exception) {
        log.error("统一异常处理:", exception);
        String message = exception.getMsg();
        if (Strings.isNullOrEmpty(message)) {
            message = exception.toString();
        }
        return new Result(false, exception.getCode(), message, "");
    }
}
