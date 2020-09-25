package com.rui.mybatis_exception_token_redis.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalErrorInfoHandler {

    /**
     * 处理空指针异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public void   exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常原因是:",e);
    }


    @ExceptionHandler(value =GlobalErrorInfoException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public void   exceptionHandler(HttpServletRequest req, GlobalErrorInfoException e){
        log.error("发生运行时异常原因是:",e);
    }
}
