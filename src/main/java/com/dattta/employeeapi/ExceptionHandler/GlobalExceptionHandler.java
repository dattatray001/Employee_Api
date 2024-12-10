package com.dattta.employeeapi.ExceptionHandler;

import com.dattta.employeeapi.exception.EmployeeAlreadyExistsException;
import com.dattta.employeeapi.exception.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex) {
        ErrorResponse errorResponse = ErrorResponse.EMPLOYEE_ALREADY_EXISTS;
        return ResponseEntity
                .status(errorResponse.getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ErrorResponse errorResponse = ErrorResponse.EMPLOYEE_NOT_EXISTS;
        return ResponseEntity
                .status(errorResponse.getStatus())
                .body(errorResponse);
    }
}
