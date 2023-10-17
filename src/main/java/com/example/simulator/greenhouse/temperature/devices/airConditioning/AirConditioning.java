package com.example.simulator.greenhouse.temperature.devices.airConditioning;

import lombok.Getter;
import lombok.Setter;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDouble;

@Getter
@Setter
public class AirConditioning {

    private AirConditioningState state = AirConditioningState.OFF;

    private double targetTemperature = 20;

    public double getTemperatureSimulator(double actualTemperature, double rangeMin, double rangeMax) {
        double randomTemperature = generateRandomDouble(rangeMin, rangeMax) * state.getGrownBonus();

        if (actualTemperature > targetTemperature)
            return randomTemperature * -1;
        return randomTemperature;
    }
}
