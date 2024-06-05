package com.uber.lld.Vehicle;

import com.uber.lld.Driver;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Moto implements Vehicle {
    public Driver driver;
    public String licenceNumber;

    @Override
    public VehicleType getType() {
        return VehicleType.CAB;
    }
}
