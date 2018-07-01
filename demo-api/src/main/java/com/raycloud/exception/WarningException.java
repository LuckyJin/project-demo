package com.raycloud.exception;

/**
 * Created by baomingfeng at 2017-09-30 10:40:02
 */
public class WarningException extends PlatformException {
    public WarningException() {
        this(null, null);
    }

    public WarningException(String msg) {
        this(msg, null);
    }

    public WarningException(Throwable cause) {
        this(null, cause);
    }

    public WarningException(String msg, Throwable cause) {
        super(ErrorType.WARNING.getCode(), msg, cause);
    }
}