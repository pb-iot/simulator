package com.example.simulator.configurations.response;

import lombok.Getter;

@Getter
public class ResponseData<T> {

    private final OperationState state;

    private final T data;

    public ResponseData() {
        this.state = OperationState.SUCCESS;
        this.data = null;
    }

    public ResponseData(T data) {
        this.state = OperationState.SUCCESS;
        this.data = data;
    }

    public ResponseData(OperationState operationState, T data) {
        this.state = operationState;
        this.data = data;
    }
}


