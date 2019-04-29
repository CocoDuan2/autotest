package com.xingxing.user.controller;

import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class BaseExceptionHandler extends RuntimeException {



    @ExceptionHandler
    @ResponseBody
    public Result error(Exception e) {
        log.error("统一异常处理:",e);
        //log.error("统一异常处理:",e.getMessage());
        return new Result(false, StatusCode.ERROR, e.getMessage(),"");
    }
}
