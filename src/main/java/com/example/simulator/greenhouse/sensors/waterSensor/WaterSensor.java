package com.example.simulator.greenhouse.sensors.waterSensor;

import com.example.simulator.utils.random.RandomGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WaterSensor {

    private Double value;

    public WaterSensor() {
        this.value = RandomGenerator.generateRandomDoubleFromRange(0, 10);
    }
}
