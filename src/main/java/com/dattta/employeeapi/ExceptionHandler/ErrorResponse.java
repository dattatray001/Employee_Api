package com.dattta.employeeapi.ExceptionHandler;

import org.springframework.http.HttpStatus;

public enum ErrorResponse {
    EMPLOYEE_ALREADY_EXISTS("Employee already exists", HttpStatus.CONFLICT),
    EMPLOYEE_NOT_EXISTS("Employee does not exist", HttpStatus.NOT_FOUND);


    private final String message;
    private final HttpStatus status;

    ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
