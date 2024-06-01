package com.uber.lld.Location;

import java.util.Random;

import com.uber.lld.Utils.Utils;

final public class LocationMock {
    private LocationMock() {
    };

    static Random random = new Random();
    final static int gridSize = 100;

    public static Location moveSlightly(Location location) {
        final int dx[] = { -1, 0, 1 };
        final int dy[] = { -1, 0, 1 };
        double x = location.getX(), y = location.getY();
        int delx = 0, dely = 0;

        while (delx == 0 && dely == 0 && isWithinBounds(x, y, delx, dely)) {
            int rx = Utils.getRandomBetween(0, dx.length);
            int ry = Utils.getRandomBetween(0, dy.length);

            delx = dx[rx];
            dely = dy[ry];
        }
        return new Location(x + delx, y + dely);
    }

    public static Location getRandomLocation() {
        return new Location(Utils.getRandomBetween(0, gridSize), Utils.getRandomBetween(0, gridSize));
    }

    private static boolean isWithinBounds(double x, double y, int delx, int dely) {
        return x + delx >= 0 && x + delx < gridSize && y + dely >= 0 && y + dely < gridSize;
    }
}
