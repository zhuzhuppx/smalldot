package com.smalldot.base;

public class ExeResult<T> {
    private Integer code;
    private Boolean success;
    private String errorMsg;
    private T data;

    public ExeResult(Integer code, Boolean success, String errorMsg, T data) {
        this.code = code;
        this.success = success;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public ExeResult(Integer code, boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.errorMsg = msg;
    }

    public static ExeResult success(Object save) {
        return new ExeResult(ResultCodeEnum.SUCCESS.getCode(), true, "", save);
    }

    public static ExeResult fail(String msg) {
        return new ExeResult(ResultCodeEnum.FAIL.getCode(), false, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
