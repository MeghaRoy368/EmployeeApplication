package com.example.EmployeeApplication.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${data.exception.message1}")
    private String message1;

    @Value(value = "${data.exception.message2}")
    private String message2;

    @Value(value = "${data.exception.message3}")
    private String message3;

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<String> UserAlreadyExistsException(UserAlreadyExistException userAlreadyExistsException){
        return new ResponseEntity<String>(message1, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> UserNotFoundException(UserNotFoundException userNotFoundException){
        return new ResponseEntity<String>(message2, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = FieldCanNotBeNullException.class)
    public ResponseEntity<String> FieldCannotBeNull(FieldCanNotBeNullException fieldCanNotBeNullException){
        return new ResponseEntity<String>(message3, HttpStatus.CONFLICT);
    }
}
