package com.example.simulator.exceptions;

import com.example.simulator.configurations.response.ResponseData;
import com.example.simulator.exceptions.basic.BaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    /**
     * It catches all exceptions BaseException
     */
    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<Object> BaseException(BaseException e) {
        Timestamp timestamp = Timestamp.from(Instant.now());
        log.warn("ApiExceptionHandler [BaseException] Exception -> \n " +
                "Date: " + timestamp + " \n " +
                "Message Exception: " + e.getMessage() + " \n " +
                "Stacktrace Exception: ", e);
        HttpStatus httpStatus = e.getHttpStatus();

        ApiException apiException = new ApiException(
                httpStatus,
                e.getMessage(),
                timestamp
        );

        ResponseData<ApiException> response = new ResponseData<>(e.getMessage(), apiException);
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * It catches all exceptions from @Valid
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<Object> HandlerApiRequestBadRequestValidException(Exception e) {
        Timestamp timestamp = Timestamp.from(Instant.now());
        log.warn("ApiExceptionHandler [HandlerApiRequestBadRequestValidException] Exception -> \n " +
                "Date: " + timestamp + " \n " +
                "Message Exception: " + e.getMessage() + " \n " +
                "Stacktrace Exception: ", e);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                httpStatus,
                e.getMessage(),
                timestamp
        );
        ResponseData<ApiException> response = new ResponseData<>(httpStatus.name(), apiException);
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * It catches any unhandled exceptions
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> HandlerApiRequestInternalException(Exception e) {
        Timestamp timestamp = Timestamp.from(Instant.now());
        log.error("ApiExceptionHandler [HandlerApiRequestInternalException] Exception -> \n " +
                "Date: " + timestamp + " \n " +
                "Message Exception: " + e.getMessage() + " \n " +
                "Stacktrace Exception: ", e);

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiException apiException = new ApiException(
                httpStatus,
                e.getMessage(),
                timestamp
        );
        ResponseData<ApiException> response = new ResponseData<>(httpStatus.name(), apiException);

        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Response error class
     */
    @AllArgsConstructor
    @Getter
    private static class ApiException {
        private final HttpStatus httpStatus;
        private final String message;
        private final Timestamp timestamp;
    }
}
