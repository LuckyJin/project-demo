package com.raycloud.exception;

/**
 * Created by baomingfeng at 2017-09-15 17:26:35
 */
public class RemoteApiException extends PlatformException {

    /*api服务平台*/
    private final String platform;

    /*api*/
    private final String api;

    /*api的请求参数*/
    private final Object param;

    /*api的payload，如返回结果，错误信息等*/
    private final Object payload;

    public RemoteApiException(
            String platform, String api, Object param,
            String message) {
        this(platform, api, param, null, message, null);
    }

    public RemoteApiException(
            String platform, String api, Object param,
            Object payload, String message) {
        this(platform, api, param, payload, message, null);
    }

    public RemoteApiException(
            String platform, String api, Object param,
            Throwable cause) {
        this(platform, api, param, null, null, cause);
    }

    public RemoteApiException(
            String platform, String api, Object param,
            Object payload, Throwable cause) {
        this(platform, api, param, payload, null, cause);
    }

    public RemoteApiException(
            String platform, String api, Object param,
            Object payload, String message, Throwable cause) {
        super(ErrorType.REMOTE_API.getCode(), message, cause);
        this.platform = platform;
        this.api = api;
        this.param = param;
        this.payload = payload;
    }

    public String getPlatform() {
        return platform;
    }

    public String getApi() {
        return api;
    }

    public Object getParam() {
        return param;
    }

    public Object getPayload() {
        return payload;
    }
}
