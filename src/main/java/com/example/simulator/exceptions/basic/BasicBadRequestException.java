package com.example.simulator.exceptions.basic;

import com.example.simulator.configurations.response.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BasicBadRequestException extends BaseException {
    private static final HttpStatus HTTPS_STATUS = HttpStatus.BAD_REQUEST;

    public BasicBadRequestException() {
        super(HTTPS_STATUS);
    }

    public BasicBadRequestException(ResponseMessage messageCode) {
        super(HTTPS_STATUS, messageCode.name());
    }
}
