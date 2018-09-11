package com.pinyougou.vo;

public class ResultInfo {
    private Boolean success;
    private String message;

    public static ResultInfo ok(String message){
        return new ResultInfo(true,message);
    }
    public static ResultInfo fail(String message){
        return new ResultInfo(false,message);
    }
    public ResultInfo(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultInfo() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
