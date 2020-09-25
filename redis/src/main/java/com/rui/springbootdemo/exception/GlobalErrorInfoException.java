package com.rui.springbootdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 配置异常类型为运行时异常
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class GlobalErrorInfoException extends RuntimeException{

    protected  String errorCode;

    protected String errorMsg;
}
