package com.digital.epharmacy.controller.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Author: Opatile Kelobang
 * Desc: Custom exception handler
 * Date: 24 September 2020
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyCustomExceptionHandler extends RuntimeException{

    public MyCustomExceptionHandler(String message){
        super(message);
    }
}
