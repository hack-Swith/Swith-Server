package com.example.swithserver.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> customExceptionHandling(CustomException e) {
        final ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(
                CustomErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build(),
                HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> bindExceptionHandling(BindException e) {
        Map<String, String> errorsList = new HashMap<>();
        for (FieldError error : e.getFieldErrors()) {
            errorsList.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<CustomErrorResponse> HandleNullPointerException(final NullPointerException e) {
        log.error("[NullPointerException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CustomErrorResponse> HandleValidationException(final MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append(fieldError.getField()).append("(을)를 ");
            builder.append(fieldError.getDefaultMessage()).append("   ");
        }

        log.error("[HandleValidationException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(400, builder.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<CustomErrorResponse> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("[HttpRequestMethodNotSupportedException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(405, e.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<CustomErrorResponse> NoHandlerFoundException(NoHandlerFoundException e){
        log.error("[NoHandlerFoundException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(404, "요청한 페이지를 찾을 수 없습니다. { URL : " +  e.getRequestURL() + " }"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    protected ResponseEntity<CustomErrorResponse> MissingRequestHeaderException(Exception e) {
        log.error("[MissingRequestHeaderException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<CustomErrorResponse> MissingServletRequestParameterException(Exception e) {
        log.error("[MissingServletRequestParameterException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    protected ResponseEntity<CustomErrorResponse> MissingServletRequestPartException(Exception e) {
        log.error("[MissingServletRequestPartException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<CustomErrorResponse> IllegalArgumentException(Exception e) {
        log.error("[IllegalArgumentException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<CustomErrorResponse> ConstraintViolationException(Exception e) {
        log.error("[ConstraintViolationException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<CustomErrorResponse> HttpMessageNotReadableException(Exception e) {
        log.error("[HttpMessageNotReadableException] : " + e.getMessage());
        return new ResponseEntity<>(new CustomErrorResponse(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<CustomErrorResponse> handleException(Exception e) {
        log.error("[exception] : " + e.getMessage(), e);
        return new ResponseEntity<>(new CustomErrorResponse(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}