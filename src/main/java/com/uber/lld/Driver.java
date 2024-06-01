package com.uber.lld;

public class Driver extends User implements LocationFetchable {
    LocationManager locationManager;

    public Driver(String name, LocationManager locationManager) {
        super(name);
        this.locationManager = locationManager;
    }

    @Override
    public Location getLocation() {
        return locationManager.getLocation();
    }
}
