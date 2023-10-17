package com.example.simulator.utils.random;

import java.util.Random;

public class RandomGenerator {

    public static int generateRandomNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException();
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static double generateRandomDouble(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException();
        }

        return min + Math.random() * (max - min);
    }
}
