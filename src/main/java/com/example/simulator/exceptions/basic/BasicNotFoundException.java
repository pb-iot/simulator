package com.example.simulator.exceptions.basic;

import com.example.simulator.configurations.response.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class BasicNotFoundException extends BaseException {
    private static final HttpStatus HTTPS_STATUS = HttpStatus.NOT_FOUND;


    public BasicNotFoundException() {
        super(HTTPS_STATUS);
    }

    public BasicNotFoundException(ResponseMessage messageCode) {
        super(HTTPS_STATUS, messageCode.name());
    }
}
