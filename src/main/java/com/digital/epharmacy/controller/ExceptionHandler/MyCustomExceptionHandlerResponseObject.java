package com.digital.epharmacy.controller.ExceptionHandler;
/*
 * Author: Opatile Kelobang
 * Desc: Custom Exception handler response object
 * Date: 24 September 2020
 */

public class MyCustomExceptionHandlerResponseObject {

    private String response;

    public MyCustomExceptionHandlerResponseObject(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
