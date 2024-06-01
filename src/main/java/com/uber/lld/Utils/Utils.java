package com.uber.lld.Utils;

import java.util.Random;
import java.util.UUID;

public class Utils {
    private Utils() {
    }

    private static Random random = new Random();

    public static int getRandomBetween(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
