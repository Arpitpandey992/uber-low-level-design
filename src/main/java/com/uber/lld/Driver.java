package com.uber.lld;

import com.uber.lld.Location.Location;
import com.uber.lld.Location.LocationFetchable;
import com.uber.lld.Location.LocationManager;
import com.uber.lld.Vehicle.Vehicle;
import com.uber.lld.Vehicle.VehicleType;

public class Driver extends User implements LocationFetchable {
    private LocationManager locationManager;
    private Vehicle vehicle;

    public Driver(String name, LocationManager locationManager, Vehicle vehicle) {
        super(name);
        this.locationManager = locationManager;
        this.vehicle = vehicle;
    }

    @Override
    public Location getLocation() {
        return locationManager.getLocation();
    }

    public VehicleType getVehicleType() {
        return vehicle.getType();
    }
}
