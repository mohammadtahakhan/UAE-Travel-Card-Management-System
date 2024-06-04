package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.constant.TransportType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Journey {
    private Station startStation;
    private Station endStation;
    private TransportType transportType;
    private boolean journeyCompleted;
}
