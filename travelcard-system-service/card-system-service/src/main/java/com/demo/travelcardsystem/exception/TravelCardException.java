package com.demo.travelcardsystem.exception;

public abstract class TravelCardException extends RuntimeException{
    protected TravelCardException(String message) {
        super(message);
    }

    protected TravelCardException() {
    }
}
