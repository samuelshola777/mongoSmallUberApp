package com.example.mongosmalluberapp.driver.exeption;

public class DriverException extends Exception{
    private  String message;
    public DriverException(String message) {
        super(message);
    }
}
