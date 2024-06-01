package com.uber.lld.PriceCalculator;

import java.util.EnumMap;

import com.uber.lld.Driver;
import com.uber.lld.Passenger;
import com.uber.lld.Vehicle.VehicleType;

public class EuclideanPricingCalculator extends PricingCalculator {
    static EnumMap<VehicleType, Double> pricePerUnitDistanceVehicleMap = new EnumMap<>(VehicleType.class) {
        {
            put(VehicleType.CAB, 10.4); // should ideally get from config file
            put(VehicleType.AUTO, 7.5);
            put(VehicleType.MOTO, 5.2);
        }
    };

    public EuclideanPricingCalculator(Driver driver, Passenger passenger) {
        super(driver, passenger);
    }

    @Override
    public double calculatePrice() {
        VehicleType vehicleType = getDriver().getVehicleType();
        double pricePerUnitDistance = pricePerUnitDistanceVehicleMap.get(vehicleType);
        double distance = driver.getLocation().euclideanDistanceFrom(passenger.getLocation());
        return distance * pricePerUnitDistance;
    }

}
