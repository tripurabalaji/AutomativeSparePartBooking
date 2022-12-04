package com.example.AutomativeSparePartBooking.Exceptions;

import org.springframework.http.HttpStatus;

public class SparePartNotAvailableException extends RuntimeException{
    public SparePartNotAvailableException(String message){
        super(message);
    }

    public SparePartNotAvailableException(HttpStatus conflict, String spare_already_exists, Exception e){

    }
}
