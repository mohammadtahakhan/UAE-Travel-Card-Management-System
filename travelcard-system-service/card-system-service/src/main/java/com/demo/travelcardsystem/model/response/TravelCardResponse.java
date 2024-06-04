package com.demo.travelcardsystem.model.response;

import com.demo.travelcardsystem.constant.TransportType;
import lombok.Data;

@Data
public class TravelCardResponse {
    private String cardNumber;
    private double balance;
    private boolean inTransit;
    private TransportType transportType;
}
