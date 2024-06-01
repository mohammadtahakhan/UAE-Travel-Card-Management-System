package com.demo.travelcardsystem.model.request;

import com.demo.travelcardsystem.constant.TransportType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties
public class SwipeRequest implements Serializable {
    private String cardNumber;
    private String stationName;
    private TransportType transportType;
}
