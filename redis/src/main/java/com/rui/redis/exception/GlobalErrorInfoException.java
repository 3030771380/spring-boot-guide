package com.rui.redis.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class GlobalErrorInfoException extends RuntimeException{

    protected  String errorCode;

    protected String errorMsg;
}
