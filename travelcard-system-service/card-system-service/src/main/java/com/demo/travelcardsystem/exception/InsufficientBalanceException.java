package com.demo.travelcardsystem.exception;

public class InsufficientBalanceException extends TravelCardException {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
