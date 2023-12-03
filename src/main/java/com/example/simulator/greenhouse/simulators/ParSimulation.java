package com.example.simulator.greenhouse.simulators;

import com.example.simulator.greenhouse.devices.light.Light;
import com.example.simulator.greenhouse.sensors.parSensor.ParSensor;

public class ParSimulation implements Simulable{

    private final ParSensor sensor = new ParSensor();
    private final Light light = new Light();

    @Override
    public void triggerSimulation() {

    }

    @Override
    public Double getSimulatedValue() {
        return null;
    }
}
