package com.cn.exception;

/**
 * Created by baomingfeng at 2017-09-15 17:26:35
 */
public class NoSessionException extends PlatformException {
    public NoSessionException() {
        this(null, null);
    }

    public NoSessionException(String msg) {
        this(msg, null);
    }

    public NoSessionException(Throwable cause) {
        this(null, cause);
    }

    public NoSessionException(String msg, Throwable cause) {
        super(ErrorType.NO_SESSION.getCode(), msg, cause);
    }
}
