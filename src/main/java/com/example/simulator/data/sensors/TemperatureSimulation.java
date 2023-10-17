package com.example.simulator.data.sensors;

import com.example.simulator.data.Simulable;
import com.example.simulator.data.Targetable;
import lombok.*;

import java.util.Random;

@Data
public class TemperatureSimulation implements Simulable, Targetable {
    private Double simulatedValue;

    private Double targetValue;

    private Double randomizationValue = 2d;
    private Double changeSpeed = .1;

    public TemperatureSimulation(Double simulatedValue, Double targetValue) {
        this.simulatedValue = simulatedValue;
        this.targetValue = targetValue;
    }

    public void triggerSimulation() {
        Random random = new Random();

        var deltaRaw = targetValue - simulatedValue;

        var delta = (deltaRaw * changeSpeed) + ((random.nextDouble() - .5) * randomizationValue);

        simulatedValue += round(delta, 1);
    }

    // wyjac do jakiegos utila
    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
