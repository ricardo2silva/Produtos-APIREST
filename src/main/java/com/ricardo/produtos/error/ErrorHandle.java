package com.ricardo.produtos.error;

public class ErrorHandle {
    private String field;
    private String message;

    public ErrorHandle(String field, String message) {
        this.field = field;
        this.message = message;
    }
    public ErrorHandle(){}

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
