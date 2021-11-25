package com.assessment.activedge.responses;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private String message;
    private HttpStatus status;
    private T data;


    public ApiResponse(HttpStatus status, String message){
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public ApiResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }


    public HttpStatus getStatus(){return status;}

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", status=" + status +
                '}';
    }
}
