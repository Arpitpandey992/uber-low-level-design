package com.uber.lld;

public interface DriveService {
    void addDriver(Driver driver);

    void removeDriver(Driver driver);

    /**
     * From the pool of available drivers, match the ideal driver for a given
     * passenger. When assignDriver is called, ensure that all drivers are available
     * and not currently in a ride. We can optimize by allowing conflicts but when
     * assigning driver, check for lock
     * 
     * @param passenger
     * @return Driver
     * @throws NoDriverAvailableException
     */
    Driver assignDriver(Passenger passenger) throws NoDriverAvailableException;

    public class NoDriverAvailableException extends Exception {
        public NoDriverAvailableException(String message) {
            super(message);
        }
    }
}
