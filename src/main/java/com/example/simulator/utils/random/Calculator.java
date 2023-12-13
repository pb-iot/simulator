package com.example.simulator.utils.random;

import java.util.List;

public class Calculator {

    public static double calculateAverage(List<Double> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        double sum = 0.0;

        for (double number : list) {
            sum += number;
        }

        return sum / list.size();
    }
}
