package com.example.AutomativeSparePartBooking.Exceptions;

import org.springframework.http.HttpStatus;

public class SparePartDuplicateException extends RuntimeException{

    public SparePartDuplicateException(String message){
        super(message);
    }

    public SparePartDuplicateException(HttpStatus conflict, String spare_already_exists, Exception e) {
    }
}
