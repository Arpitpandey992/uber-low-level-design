package com.uber.lld.Location;

import com.uber.lld.Observer.Observer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class LocationObserver implements Observer {
    private String name;
    private LocationManager locationManager;

    @Override
    public abstract void notifyChange();
}
