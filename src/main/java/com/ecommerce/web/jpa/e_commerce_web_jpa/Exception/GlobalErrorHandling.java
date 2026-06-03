package com.ecommerce.web.jpa.e_commerce_web_jpa.Exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandling {

    @ExceptionHandler(exception = ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolaation(ConstraintViolationException exception) {

        log.error(exception.getConstraintName() + ": " + exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Terjadi kesalahan : " +
                exception.getMessage());
    }

}
