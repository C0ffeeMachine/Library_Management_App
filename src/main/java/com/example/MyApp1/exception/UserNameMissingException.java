package com.example.MyApp1.exception;

public class UserNameMissingException extends RuntimeException{
    public UserNameMissingException(){
        super("Name field is missing!");
    }
}
