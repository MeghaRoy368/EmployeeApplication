package com.example.EmployeeApplication.exception;

public class FieldCanNotBeNullException extends Exception{
    private String message;

    public FieldCanNotBeNullException() {
    }

    public FieldCanNotBeNullException(String message) {
        super();
        this.message = message;
    }
}
