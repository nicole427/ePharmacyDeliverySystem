package com.digital.epharmacy.service.Validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/*
 * Author: Opatile Kelobang
 * Desc: Validation service to assist with generic Post Man Response requests
 * Date: 24 Spetember 2020
 */
@Service
public class ValidationService {

    public ResponseEntity<?> MapValidationService(BindingResult result) {
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}
