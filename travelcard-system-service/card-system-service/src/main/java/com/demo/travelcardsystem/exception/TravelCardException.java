package com.demo.travelcardsystem.exception;

public abstract class TravelCardException extends RuntimeException{
    public TravelCardException(String message) {
        super(message);
    }

    public TravelCardException() {
    }
}
