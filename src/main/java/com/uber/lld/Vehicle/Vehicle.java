package com.uber.lld.Vehicle;

import com.uber.lld.Driver;

public interface Vehicle {
    Driver getDriver();

    String getLicenceNumber();

    VehicleType getType();
}
