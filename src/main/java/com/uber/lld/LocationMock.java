package com.uber.lld;

import java.util.Random;

final public class LocationMock {
    private LocationMock() {
    };

    static Random random = new Random();
    final static int gridSize = 100;

    public static Location moveSlightly(Location location) {
        final int dx[] = { -1, 0, 1 };
        final int dy[] = { -1, 0, 1 };
        int x = location.getX(), y = location.getY();
        int delx = 0, dely = 0;

        while (delx == 0 && dely == 0 && isWithinBounds(x, y, delx, dely)) {
            int rx = random.nextInt(dx.length);
            int ry = random.nextInt(dy.length);

            delx = dx[rx];
            dely = dy[ry];
        }
        return new Location(x + delx, y + dely);
    }

    public static Location getRandomLocation() {
        Random random = new Random();
        return new Location(random.nextInt(gridSize), random.nextInt(gridSize));
    }

    private static boolean isWithinBounds(int x, int y, int delx, int dely) {
        return x + delx >= 0 && x + delx < gridSize && y + dely >= 0 && y + dely < gridSize;
    }
}
