package com.example.myapplication.demo;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/26 11:30
 */
public class BaseData<T> {
    private T data;
    private String message;

    public BaseData() {
    }

    public BaseData(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
