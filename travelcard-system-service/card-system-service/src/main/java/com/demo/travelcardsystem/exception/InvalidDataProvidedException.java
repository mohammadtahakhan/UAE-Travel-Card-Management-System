package com.demo.travelcardsystem.exception;

public class InvalidDataProvidedException extends TravelCardException {
    public InvalidDataProvidedException(String message) {
        super(message);
    }

    public InvalidDataProvidedException() {
    }
}
