package com.uber.lld.Location;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Location {
    double x, y;

    public double euclideanDistanceFrom(Location l2) {
        return Math.abs(x * x - l2.getX() * l2.getX()) + Math.abs(y * y - l2.getY() * l2.getY());
    }
}
