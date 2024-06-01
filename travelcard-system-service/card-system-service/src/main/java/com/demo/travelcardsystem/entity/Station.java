package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.constant.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Station {
    private String name;
    private Set<Zone> zones;
}
