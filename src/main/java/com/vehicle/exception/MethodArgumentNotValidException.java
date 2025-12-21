package com.vehicle.exception;

public class MethodArgumentNotValidException extends RuntimeException{

    public MethodArgumentNotValidException(String  msg){
        super(msg);
    }
}
