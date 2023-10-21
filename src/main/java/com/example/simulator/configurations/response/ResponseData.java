package com.example.simulator.configurations.response;

import lombok.Getter;

@Getter
public class ResponseData<T> {

    private final String message;

    private final T data;

    public ResponseData() {
        this.message = ResponseMessage.SUCCESS.name();
        this.data = null;
    }

    public ResponseData(T data) {
        this.message = ResponseMessage.SUCCESS.name();
        this.data = data;
    }

    public ResponseData(String message, T data) {
        this.message = message;
        this.data = data;
    }
}


