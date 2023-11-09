package com.example.simulator.exceptions.basic;

import com.example.simulator.configurations.response.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BasicAuthenticationException extends BaseException {
    private static final HttpStatus HTTPS_STATUS = HttpStatus.UNAUTHORIZED;

    public BasicAuthenticationException() {
        super(HTTPS_STATUS);
    }

    public BasicAuthenticationException(ResponseMessage messageCode) {
        super(HTTPS_STATUS, messageCode.name());

    }
}
