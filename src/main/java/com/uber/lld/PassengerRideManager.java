package com.uber.lld;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PassengerRideManager {
    private Passenger passenger;
    private DriveService driveService;

    public Driver assignDriver() throws DriverAssignmentException {
        try {
            Driver assignedDriver = driveService.assignDriver(passenger);
            if (assignedDriver == null) {
                throw new DriverAssignmentException("Could not assign driver, please try again later");
            }
            return assignedDriver;
        } catch (Exception e) {
            throw new DriverAssignmentException(e);
        }
    }

    public static class DriverAssignmentException extends Exception {
        public DriverAssignmentException(String message) {
            super(message);
        }

        public DriverAssignmentException(Throwable e) {
            super(e);
        }

        public DriverAssignmentException(String var1, Throwable var2) {
            super(var1, var2);
        }
    }

}
