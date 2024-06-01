package com.demo.travelcardsystem.service.util;

import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.model.response.TravelCardResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TravelCardConverter {
    public Function<TravelCard, TravelCardResponse> travelCard2TravelCardResponseConverter = travelCard -> {
        TravelCardResponse travelCardResponse = new TravelCardResponse();
        travelCardResponse.setCardNumber(travelCard.getCardNumber());
        travelCardResponse.setBalance(travelCard.getBalance());
        if(null != travelCard.getCurrentJourney()) {
            travelCardResponse.setTransportType(travelCard.getCurrentJourney().getTransportType());
        }

        //if current journey is not null mean card is in-transit
        travelCardResponse.setInTransit(travelCard.getCurrentJourney() != null);

        return travelCardResponse;
    };
}
