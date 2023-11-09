package com.example.simulator.exceptions.basic;

import com.example.simulator.configurations.response.ResponseMessage;
import org.springframework.http.HttpStatus;

public class BasicFailedDependencyException extends BaseException {
    private static final HttpStatus HTTPS_STATUS = HttpStatus.FAILED_DEPENDENCY;

    public BasicFailedDependencyException() {
        super(HTTPS_STATUS);
    }

    public BasicFailedDependencyException(ResponseMessage messageCode) {
        super(HTTPS_STATUS, messageCode.name());

    }
}
