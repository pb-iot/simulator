package com.example.simulator.greenhouse.temperature;

import com.example.simulator.greenhouse.temperature.devices.airConditioning.AirConditioning;
import com.example.simulator.greenhouse.temperature.devices.airConditioning.AirConditioningState;
import com.example.simulator.greenhouse.temperature.devices.temperatureSensor.TemperatureSensor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Temperature {

    private final TemperatureSensor temperatureSensor = new TemperatureSensor();

    private final AirConditioning airConditioning = new AirConditioning();

    public void ACSimulator(double rangeMin, double rangeMax) {
        double changeTemperature = airConditioning.getTemperatureSimulator(temperatureSensor.getValue(), rangeMin, rangeMax);

        temperatureSensor.setValue(temperatureSensor.getValue() + changeTemperature);
        airConditioning.setState(AirConditioningState.TURBO);
        log.info("Temperature: {}", temperatureSensor.getValue());
    }
}
