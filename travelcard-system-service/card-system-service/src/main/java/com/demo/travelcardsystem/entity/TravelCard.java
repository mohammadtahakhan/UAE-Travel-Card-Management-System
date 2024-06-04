package com.demo.travelcardsystem.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public  class TravelCard implements Observable {

    @EqualsAndHashCode.Include
    private String cardNumber;
    private double balance;
    private Journey currentJourney;

    public synchronized void addCredit(double amount) {
        balance += amount;
    }

    public synchronized void debitAmount(double amount) {
        balance -= amount;
    }

    @Override
    public void notifyAllObservers() {
        observerCollection.forEach(observer -> {
            observer.reactOnChange(this);
        });
    }

    @Override
    public void registerObserver(Observer observer) {
        observerCollection.add(observer);
    }
}
