package com.ekan.exceptions.handler;

import com.ekan.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handlerBusinessException(BusinessException ex, HttpServletRequest request) {
        return response(ex.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
    }
     @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ErrorResponse> handlerUnprocessableEntity(UnprocessableEntityException ex, HttpServletRequest request) {
        return response(ex.getMessage(), request, HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now());
    }
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handlerConflictException(ConflictException ex, HttpServletRequest request) {
        return response(ex.getMessage(), request, HttpStatus.CONFLICT, LocalDateTime.now());
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundExcption(NotFoundException ex, HttpServletRequest request) {
        return response(ex.getMessage(), request, HttpStatus.NOT_FOUND, LocalDateTime.now());
    }
    @ExceptionHandler(UnauthorizedTransactionException.class)
    public ResponseEntity<ErrorResponse> unprocessableEntity(UnauthorizedTransactionException ex, HttpServletRequest request) {
        return response(ex.getMessage(), request, HttpStatus.NOT_FOUND, LocalDateTime.now());
    }
    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<ErrorResponse> invalidTransactionException(InvalidTransactionException ex, HttpServletRequest request) {
        return response(ex.getMessage(), request, HttpStatus.NOT_FOUND, LocalDateTime.now());
    }

    private ResponseEntity<ErrorResponse> response(final String message, final HttpServletRequest request, final HttpStatus status, LocalDateTime data) {
        return ResponseEntity
                .status(status)
                .body(new ErrorResponse(message, data, status.value(), request.getRequestURI()));
    }
}
