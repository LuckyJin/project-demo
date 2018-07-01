package com.raycloud.exception;

/**
 * Created by baomingfeng at 2017-09-04 19:41:20
 */
public enum ErrorType {

    //1xx: ok
    SUCCESS(100, "Success"),
    WARNING(101, "Warning"),

    NO_SESSION(300, "No Session Error"),

    ILLEGAL_PARAM(400, "Illegal Param Error"),

    REMOTE_API(500, "Remote Api Error"),

    BUSINESS(600, "Business Error"),
    PRIVILEGE(601, "Privilege Error"),//用户权限错误（尊享版业务）

    UNDEFINED(0, "Undefined Error"),;

    private final int code;
    private final String error;

    ErrorType(int code, String error) {
        this.code = code;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public static ErrorType valueOf(int code) {
        switch (code) {
            case 100:
                return SUCCESS;
            case 101:
                return WARNING;
            case 300:
                return NO_SESSION;
            case 400:
                return ILLEGAL_PARAM;
            case 500:
                return REMOTE_API;
            case 600:
                return BUSINESS;
            case 0:
                return UNDEFINED;
            default:
                return null;
        }
    }

    public static String getError(int code) {
        ErrorType type = valueOf(code);
        if (type != null) {
            return type.getError();
        }
        return null;
    }
}
