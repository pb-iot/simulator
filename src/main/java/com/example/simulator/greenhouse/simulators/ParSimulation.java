package com.example.simulator.greenhouse.simulators;

import com.example.simulator.DTOs.LightDTO;
import com.example.simulator.DTOs.WaterDTO;
import com.example.simulator.greenhouse.devices.light.Light;
import com.example.simulator.greenhouse.devices.light.LightState;
import com.example.simulator.greenhouse.devices.water.WaterAction;
import com.example.simulator.greenhouse.sensors.parSensor.ParSensor;

import java.util.Objects;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDoubleFromRange;

public class ParSimulation implements Simulable{

    private final double MAX_VALUE = 400.00;
    private final double MIN_VALUE = 0;

    private final ParSensor parSensor = new ParSensor();
    private final Light light = new Light();

    @Override
    public void triggerSimulation() {
        double changePar = getSensorChange();

        parSensor.setParValue(0.00);
    }

    private double getSensorChange() {
        if(light.getState().getState() == LightState.ON.getState()) {
            return generateRandomDoubleFromRange(0, 1);
        }
        return 0;
    }

    private double getLightChange() {
        if(light.getState().getState() == LightState.ON.getState()) {
            return generateRandomDoubleFromRange(0, 1);
        }
        return 0;
    }


    public void setLightSwitch(LightDTO dto) {
        if (Objects.nonNull(dto.getLightState()))
            light.setState(dto.getLightState());
    }

    @Override
    public Double getSimulatedValue() {
        parSensor.updateParValue();
        return parSensor.getParValue();
    }
}
