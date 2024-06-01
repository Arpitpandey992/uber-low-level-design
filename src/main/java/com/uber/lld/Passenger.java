package com.uber.lld;

import com.uber.lld.Location.Location;
import com.uber.lld.Location.LocationFetchable;
import com.uber.lld.Location.LocationManager;

public class Passenger extends User implements LocationFetchable {
    LocationManager locationManager;

    public Passenger(String name, LocationManager locationManager) {
        super(name);
        this.locationManager = locationManager;
    }

    @Override
    public Location getLocation() {
        return locationManager.getLocation();
    }
}