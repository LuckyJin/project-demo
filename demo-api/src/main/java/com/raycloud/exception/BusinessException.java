package com.cn.exception;

/**
 * Created by baomingfeng at 2017-09-15 17:26:35
 * <p>
 * business exception多种code，默认ErrorType.BUSINESS.getCode()
 */
public class BusinessException extends PlatformException {
    public BusinessException() {
        this(null, null);
    }

    public BusinessException(String msg) {
        this(msg, null);
    }

    public BusinessException(int code, String msg) {
        this(code, msg, null);
    }

    public BusinessException(Throwable cause) {
        this(null, cause);
    }

    public BusinessException(int code, Throwable cause) {
        this(code, null, cause);
    }

    public BusinessException(String msg, Throwable cause) {
        this(ErrorType.BUSINESS.getCode(), msg, cause);
    }

    public BusinessException(int code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}
