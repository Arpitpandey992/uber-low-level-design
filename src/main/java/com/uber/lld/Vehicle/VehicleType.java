package com.uber.lld.Vehicle;

public enum VehicleType {
    CAB("Cab"),
    AUTO("Auto"),
    MOTO("Moto");

    private final String value;

    VehicleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}