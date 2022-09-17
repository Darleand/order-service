package com.artzvrzn.order.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<?> IllegalArgumentHandler(IllegalArgumentException exc) {
        return new ResponseEntity<>(new Error("error", exc.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    public ResponseEntity<?> illegalStateHandler(IllegalStateException exc) {
        return new ResponseEntity<>(new Error("error", exc.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
