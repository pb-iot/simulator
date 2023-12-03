package com.example.simulator.greenhouse.simulators;

import com.example.simulator.DTOs.WaterDTO;
import com.example.simulator.greenhouse.devices.airConditioning.AirConditioning;
import com.example.simulator.greenhouse.devices.water.Water;
import com.example.simulator.greenhouse.devices.water.WaterAction;
import com.example.simulator.greenhouse.sensors.waterSensor.WaterSensor;

import java.util.Objects;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDoubleFromRange;

public class WaterSimulation implements Simulable{

    private final double RANGE_MIN = 0.05;
    private final double RANGE_MAX = 0.40;

    private final WaterSensor waterSensor = new WaterSensor();

    private final Water water = new Water();

    @Override
    public void triggerSimulation() {
        double waterLevel = getSensorChange();

        if (waterSensor.getValue() + waterLevel> 100) {
            waterSensor.setValue(100d);
        } else if (waterSensor.getValue() + waterLevel < 0) {
            waterSensor.setValue(0d);
        } else {
            waterSensor.setValue(waterSensor.getValue());
        }
    }

    private double getSensorChange() {
        if(water.getAction().getAction() == WaterAction.ON.getAction()) {
            return generateRandomDoubleFromRange(RANGE_MIN, RANGE_MAX);
        }
        return 0;
    }

    public void setWaterLevel(WaterDTO dto) {
        if (Objects.nonNull(dto.getWaterAction()))
            water.setAction(dto.getWaterAction());
    }

    @Override
    public Double getSimulatedValue() {
        return waterSensor.getValue();
    }
}
