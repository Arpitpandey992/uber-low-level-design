package com.uber.lld.PriceCalculator;

import com.uber.lld.Driver;
import com.uber.lld.Passenger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class PricingCalculator {
    Driver driver;
    Passenger passenger;

    public abstract double calculatePrice();
}
