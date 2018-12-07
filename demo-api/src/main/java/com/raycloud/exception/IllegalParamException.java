package com.cn.exception;

/**
 * Created by baomingfeng at 2017-09-15 17:26:35
 */
public class IllegalParamException extends PlatformException {
    public IllegalParamException() {
        this(null, null);
    }

    public IllegalParamException(String msg) {
        this(msg, null);
    }

    public IllegalParamException(Throwable cause) {
        this(null, cause);
    }

    public IllegalParamException(String msg, Throwable cause) {
        super(ErrorType.ILLEGAL_PARAM.getCode(), msg, cause);
    }
}
