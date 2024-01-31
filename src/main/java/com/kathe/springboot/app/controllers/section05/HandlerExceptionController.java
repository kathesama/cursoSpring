package com.kathe.springboot.app.controllers.section05;

import com.kathe.springboot.app.exceptions.section05.UserNotFoundException;
import com.kathe.springboot.app.models.section05.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<CustomError> divisionByZero(Exception exception){
        return createResponseEntity(exception, "Error: division by zero", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<CustomError> notFoundExc(Exception exception){
        return createResponseEntity(exception, "Error: path not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            NoSuchElementException.class,
            UserNotFoundException.class
    })
    public ResponseEntity<CustomError> elementNotFoundEx(Exception exception){
        return createResponseEntity(exception, "Error: element not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleAllOtherExceptions(Exception exception){
        return createResponseEntity(exception, "Error: An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<CustomError> createResponseEntity(Exception exception, String errorMessage, HttpStatus status) {
        CustomError error = new CustomError();
        error.setDate(new Date());
        error.setErrorMessage(errorMessage);
        error.setMessage(exception.getMessage());
        error.setStatus(status.value());

        return ResponseEntity.status(status).body(error);
    }
}
