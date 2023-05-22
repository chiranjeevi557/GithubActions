package com.example.ford.project.exception;

import com.example.ford.project.model.ErrorResponse;
import com.example.ford.project.model.ErrorResponseWrapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ControllerAdvice
public class LibrarianControllerAdvice {

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ErrorResponseWrapper handleMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        ErrorResponse errorResponse=new ErrorResponse("HTTP",405,e.getMessage());
        ErrorResponseWrapper errorResponseWrapper=new ErrorResponseWrapper("UNAVAILABLE","4.14",errorResponse);
        return errorResponseWrapper;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ResponseEntity<ErrorResponseWrapper> handleMethodArguementMismatchException(MethodArgumentNotValidException e) {
        String description = "Wrong value provided for" + e.getMessage() + " please check the API Documentation";
        ErrorResponse errorResponse = new ErrorResponse("HTTP", 400, description);
        ErrorResponseWrapper errorResponseWrapper = new ErrorResponseWrapper("UNAVAILABLE", "", errorResponse);
        return new ResponseEntity<>(errorResponseWrapper, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public final ErrorResponseWrapper handleDataIntegrityViolationException(DataIntegrityViolationException e){
        String description = "Account already exists with the given emailID";
        ErrorResponse errorResponse = new ErrorResponse("HTTP", 409, description);
        ErrorResponseWrapper errorResponseWrapper = new ErrorResponseWrapper("CONFLICT", "", errorResponse);
        return errorResponseWrapper;
    }

}
