package com.demo.travelcardsystem.controller;

import com.demo.travelcardsystem.model.request.CardRegistrationRequest;
import com.demo.travelcardsystem.model.request.SwipeRequest;
import com.demo.travelcardsystem.model.response.TravelCardResponse;
import com.demo.travelcardsystem.service.TravellerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/card")
@AllArgsConstructor
@CrossOrigin
public class TravellerController {

    private TravellerService travellerService;

    @GetMapping(value = "/ping")
    public String pingMe() {
        return "Service is UP and Running";
    }

    @PostMapping(value = "/register")
    public void registerNewUser(@RequestBody CardRegistrationRequest cardRegistrationRequest) {
        travellerService.registerNewCard(cardRegistrationRequest);
    }

    @PostMapping(value = "/recharge/{rechargeAmount}")
    public void rechargeTheCard(@RequestBody String cardNumber, @PathVariable double rechargeAmount) {
        travellerService.rechargeTheCard(cardNumber, rechargeAmount);
    }

    @PostMapping(value = "/swipe")
    public TravelCardResponse swipeCard(@RequestBody SwipeRequest swipeRequest) {
        return travellerService.swipeCard(swipeRequest);
    }

    @GetMapping(value = "/{cardNumber}")
    public TravelCardResponse checkCardDetail(@PathVariable String cardNumber) {
        return travellerService.checkCardDetail(cardNumber);
    }

    @GetMapping
    public List<String> fetchAllCard() {
        return travellerService.fetchAllCard();
    }


}
