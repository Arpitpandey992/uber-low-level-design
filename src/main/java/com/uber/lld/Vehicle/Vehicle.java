package com.uber.lld.Vehicle;

import com.uber.lld.Driver;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Vehicle {
    private Driver driver;
    private String licenceNumber;

    public abstract VehicleType getType();
}
