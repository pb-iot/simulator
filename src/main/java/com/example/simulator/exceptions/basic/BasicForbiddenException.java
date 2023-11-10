package com.example.simulator.exceptions.basic;

import com.example.simulator.configurations.response.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class BasicForbiddenException extends BaseException {
    private static final HttpStatus HTTPS_STATUS = HttpStatus.FORBIDDEN;


    public BasicForbiddenException() {
        super(HTTPS_STATUS);
    }

    public BasicForbiddenException(ResponseMessage messageCode) {
        super(HTTPS_STATUS, messageCode.name());

    }
}
