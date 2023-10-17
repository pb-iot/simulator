package com.example.simulator.data.sensors;

import com.example.simulator.data.Simulable;
import lombok.*;

import java.util.Random;

@Data
public class TemperatureSimulation implements Simulable {
    private Double simulatedValue;

    private Double defaultValue;

    private Double maxValue;

    private Double changeValue = 0d;

    private Double randomizationValue = 2d;
    private Double changeSpeed = .1;

    public TemperatureSimulation(Double simulatedValue, Double defaultValue, Double maxValue) {
        this.simulatedValue = simulatedValue;
        this.defaultValue = defaultValue;
        this.maxValue = maxValue;
    }

    public void triggerSimulation() {
        Random random = new Random();

        var deltaRaw = defaultValue - simulatedValue;

        var delta =
                (deltaRaw * changeSpeed) +
                ((random.nextDouble() - .5) * randomizationValue) +
                changeValue;

        simulatedValue += round(delta, 1);

        if (simulatedValue > maxValue) simulatedValue = maxValue;
    }

    // wyjac do jakiegos utila
    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
