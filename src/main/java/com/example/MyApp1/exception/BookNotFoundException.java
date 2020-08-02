package com.example.MyApp1.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(int id){
        super("Book id not found "+id);
    }
}