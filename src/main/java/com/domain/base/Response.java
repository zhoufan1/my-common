package com.domain.base;

public class Response<T> {

    public static final String SUCCESS_CODE = "8000";
    public static final String SUCCESS_CODE_DESC = "SUCCESS";

    public static final String SYSTEM_ERROR_CODE = "6000";

    private String code;
    private String msg;
    private T result;

    public Response() {

    }

    private Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Response(String code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public static <T> Response<T> success(T result) {
        return new Response<>(SUCCESS_CODE, SUCCESS_CODE_DESC, result);
    }

    public static Response<Void> success() {
        return new Response<>(SUCCESS_CODE, SUCCESS_CODE_DESC);
    }

    public static <T> Response<T> systemError(String msg) {
        return new Response<>(SYSTEM_ERROR_CODE, msg);
    }

    public static <T> Response<T> create(BaseCode baseCode, T result) {
        return new Response<>(baseCode.getCode(), baseCode.getMessage(), result);
    }

    public static Response<Void> failed(String code, String msg) {
        return new Response<>(code, msg);
    }

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }

    public boolean error() {
        return !isSuccess();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
