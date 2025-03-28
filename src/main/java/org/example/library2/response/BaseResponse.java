package org.example.library2.response;

public class BaseResponse {

    public BaseResponse() {
    }

    public BaseResponse (boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    protected boolean success;
    protected String message;

}