package com.cn.exception;

/**
 * 平台自定义的异常
 * <p>
 * 强行约束业务等抛出的异常需要使用定义的异常
 * <p>
 * Created by baomingfeng at 2017-09-04 17:47:28
 */
public abstract class PlatformException extends RuntimeException {

    private static final long serialVersionUID = 174841398690789156L;

    private final int code;

    public PlatformException(int code) {
        this(code, null, null);
    }

    public PlatformException(int code, String msg) {
        this(code, msg, null);
    }

    public PlatformException(int code, Throwable cause) {
        this(code, null, cause);
    }

    public PlatformException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
