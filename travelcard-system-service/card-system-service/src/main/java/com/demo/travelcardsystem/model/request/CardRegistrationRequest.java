package com.demo.travelcardsystem.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CardRegistrationRequest {
    private String cardNumber;
    private Double balance;
}
