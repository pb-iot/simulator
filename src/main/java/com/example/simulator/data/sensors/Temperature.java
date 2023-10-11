package com.example.simulator.data.sensors;

import lombok.*;

import java.util.Random;

@Data
public class Temperature {
    private Double simulatedValue;
    private Double targetValue;

    public void RaiseTarget(Double value) {
        targetValue += value;
    }

    public void fluctuate() {
        Random random = new Random();

        simulatedValue += round(19 + random.nextDouble() * 2, 1);
    }

    // wyjac do jakiegos utila
    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
