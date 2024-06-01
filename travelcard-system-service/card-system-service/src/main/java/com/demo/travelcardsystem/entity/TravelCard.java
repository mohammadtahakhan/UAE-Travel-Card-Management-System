package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.businessrule.RuleCollection;
import com.demo.travelcardsystem.businessrule.TravelStrategy;
import com.demo.travelcardsystem.service.util.FareCalculator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
