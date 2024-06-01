package com.uber.lld.Location;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GpsLocationManager extends LocationManager {

    GpsLocationManager() {
        super(LocationMock.getRandomLocation());
        // for simplicity, this will slightly change location every seconds and run
        // forever
        // We should make it better by having a state manager for this and kill it if
        // it's corresponding User shuts down
        // TODO: Implement state for this.
        final int locationChangeIntervalSeconds = 5;
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        CompletableFuture.runAsync(() -> { // to make this non blocking
            scheduler.scheduleAtFixedRate(() -> {
                super.setLocation(LocationMock.moveSlightly(super.getLocation()));
                log.info("changed location to [{}]", getLocation().toString());
            }, 0, locationChangeIntervalSeconds, TimeUnit.SECONDS);
        });
    }

    public static void main(String[] args) {
        new GpsLocationManager();
    }

}
