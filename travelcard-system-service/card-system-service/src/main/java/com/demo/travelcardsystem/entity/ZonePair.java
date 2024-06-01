package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.constant.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZonePair {
    private Zone startZone;
    private Zone endZone;

    public boolean checkIfJourneyMatchToThisZonePair(Journey journey) {
        return journey.getStartStation().getZones().contains(startZone) && journey.getEndStation().getZones().contains(endZone);
    }
}
