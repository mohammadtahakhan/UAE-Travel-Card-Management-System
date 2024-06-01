package com.demo.travelcardsystem.repository;

import com.demo.travelcardsystem.entity.Station;
import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.exception.InvalidCardException;
import com.demo.travelcardsystem.exception.InvalidDataProvidedException;
import com.demo.travelcardsystem.exception.InvalidRechargeAmount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class InMemoryCardTransactionRepository {

    // Key is cardNumber
    private ConcurrentMap<String, TravelCard> travelCardStore = new ConcurrentHashMap<>();
    private Set<Station> stationStore = new HashSet<>();

    public TravelCard registerNewCard(TravelCard travelCard) {
        // Check if card already exists. Then throw exception
        if(null != travelCardStore.get(travelCard.getCardNumber())) {
            throw new InvalidCardException("This card is already registered.");
        }
        travelCardStore.put(travelCard.getCardNumber(), travelCard);
        return travelCard;
    }

    public TravelCard findCardByCardNumber(String cardNumber) {
        TravelCard travelCard = travelCardStore.get(cardNumber);
        if(travelCard == null) {
            throw new InvalidCardException("This card is Invalid. Please use a valid card");
        }

        return travelCard;
    }

    public Station findStationByName(String stationName) {
       return stationStore.stream().filter(station -> station.getName().equals(stationName)).findAny()
               .orElseThrow(InvalidDataProvidedException::new);
    }

    public boolean addAllStationsToStationStore(Set<Station> stations) {
        clearStationStore();
        return stationStore.addAll(stations);
    }

    public void clearStationStore() {
        stationStore.clear();
    }

    public void clearTravelCardStore() {
        travelCardStore.clear();
    }


    public List<String> fetchAllCardNumber() {
        return new ArrayList<>(travelCardStore.keySet());
    }
}
