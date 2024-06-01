package com.uber.lld.Location;

import java.util.HashSet;
import java.util.Set;

import com.uber.lld.Observer.Observable;
import com.uber.lld.Observer.Observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class LocationManager implements LocationFetchable, Observable {
    private Set<Observer> locationObservers;
    private Location location;

    public LocationManager(Location initialLocation) {
        this.location = initialLocation;
        this.locationObservers = new HashSet<>();
    }

    public LocationManager() {
        this.locationObservers = new HashSet<>();
    }

    @Override
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location newLocation) {
        if (this.location.equals(newLocation))
            return;
        this.location = newLocation;
        this.notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        locationObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (locationObservers.contains(observer)) {
            locationObservers.remove(observer);
        } else {
            log.warn("observer: [{}] is not observing [{}]", observer.getName(), this.getClass().getSimpleName());
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.locationObservers) {
            observer.notifyChange();
        }
    }
}
