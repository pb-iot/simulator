package com.example.simulator.exceptions.basic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Slf4j
@Getter
public abstract class BaseException extends RuntimeException {
    private final HttpStatus httpStatus;
    private String message;

    public BaseException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = httpStatus.name().toUpperCase();

        logStackTrace();
    }

    public BaseException(HttpStatus httpStatus, String message) {
        this(httpStatus);
        this.message = message;
    }

    /* IMPORTANT! */
    /* For this function to work, exception classes must end with the name "Exception" */
    // The function logs information where an exception was thrown in which function or line
    private static StackTraceElement getCallingMethod(StackTraceElement[] stackTrace) {
        for (int i = 1; i < stackTrace.length; i++) {
            String regex = ".*Exception\\.java$";

            String fileName = stackTrace[i].getFileName();
            if (Objects.isNull(fileName))
                return null;

            boolean endsWithException = fileName.matches(regex);
            if (!endsWithException)
                return stackTrace[i];
        }
        return null;
    }

    private void logStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement callingMethod = getCallingMethod(stackTrace);
        if (Objects.nonNull(callingMethod)) {
            log.warn("Exception thrown from {} in {} at line {}", callingMethod.getClassName(), callingMethod.getMethodName(), callingMethod.getLineNumber());
        }
    }
}
