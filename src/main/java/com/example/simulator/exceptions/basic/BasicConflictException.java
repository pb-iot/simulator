package com.example.simulator.exceptions.basic;

import com.example.simulator.configurations.response.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BasicConflictException extends BaseException {
    private static final HttpStatus HTTPS_STATUS = HttpStatus.CONFLICT;

    public BasicConflictException() {
        super(HTTPS_STATUS);
    }

    public BasicConflictException(ResponseMessage messageCode) {
        super(HTTPS_STATUS, messageCode.name());

    }
}
