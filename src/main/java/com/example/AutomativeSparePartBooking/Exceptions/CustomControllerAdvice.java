package com.example.AutomativeSparePartBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@org.springframework.web.bind.annotation.ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(SparePartDuplicateException.class)
    public ResponseEntity<ErrorResponse> handleSparePartDuplicateException(Exception e){
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        return new ResponseEntity<>(new ErrorResponse(httpStatus, "spare part already exists"),httpStatus);
    }

    @ExceptionHandler(SparePartNotAvailableException.class)
    public ResponseEntity<ErrorResponse> handleSparePartNotAvailableException(Exception e){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ErrorResponse(httpStatus,
                                                    e.getMessage()),
                                                    httpStatus);
    }

    //fallback it can be internal server error
    @ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<ErrorResponse> handleExceptions(Exception e) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

        // converting the stack trace to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage(),
                        stackTrace // specifying the stack trace in case of 500s
                ),
                status
        );
    }

}
