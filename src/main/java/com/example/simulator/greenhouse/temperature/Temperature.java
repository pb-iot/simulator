package com.example.simulator.greenhouse.temperature;

import com.example.simulator.greenhouse.temperature.devices.AirConditioning;
import com.example.simulator.greenhouse.temperature.devices.temperatureSensor.TemperatureSensor;
import com.example.simulator.greenhouse.temperature.simulator.TemperatureSimulator;
import lombok.Getter;

@Getter
public class Temperature {

    private TemperatureSensor temperatureSensor = new TemperatureSensor();

    private AirConditioning airConditioning = new AirConditioning();

    private TemperatureSimulator temperatureSimulator;



}
