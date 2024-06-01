package com.demo.travelcardsystem.service.util;

import com.demo.travelcardsystem.businessrule.Rule;
import com.demo.travelcardsystem.businessrule.TravelStrategy;
import com.demo.travelcardsystem.entity.Journey;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.function.Predicate;

@Data
@Component
@RequiredArgsConstructor
public class FareCalculator {

    @NonNull
    private TravelStrategy travelStrategy;

    // compare rules and pick the one has lower chargeable fare
    private Comparator<Rule> ruleComparator = (Rule firstRule, Rule secondRule) -> {
        if (firstRule.getChargeableFare() < secondRule.getChargeableFare()) {
            return -1;
        } else if (firstRule.getChargeableFare() > secondRule.getChargeableFare()) {
            return 1;
        } else {
            return 0;
        }
    };


    public Double calculate(Journey journey) {
        Predicate<Rule> rulePredicate = rule -> rule.isRuleSatisfied(journey);

        // Figure out which rule will be applicable out of all provided business rules
        Rule applicableRule = travelStrategy.getRuleCollection().getRules()
                .stream()
                .filter(rulePredicate)
                .min(ruleComparator)
                .get();

        //finally, return the chargeable fare
        return applicableRule.getChargeableFare();
    }
}
