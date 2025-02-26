package com.couse.exception.handler;

import com.couse.exception.error.ElementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class CourseExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerError(ElementNotFoundException exception){
        return new ResponseEntity<>(Collections.singletonMap("Error", exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handlerGeneralError(Exception exception){
        return new ResponseEntity<>(Collections.singletonMap("Error", exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
