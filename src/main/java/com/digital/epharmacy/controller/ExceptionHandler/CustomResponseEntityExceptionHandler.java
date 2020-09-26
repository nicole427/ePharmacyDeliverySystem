package com.digital.epharmacy.controller.ExceptionHandler;
/*
 * Author: Opatile Kelobang
 * Desc: Allows for custom Http responses
 * Date: 24 September 2020
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleException(MyCustomExceptionHandler ex, WebRequest request){
        MyCustomExceptionHandlerResponseObject exceptionResponse = new MyCustomExceptionHandlerResponseObject(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
