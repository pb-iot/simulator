package com.example.simulator.greenhouse.sensors.salinitySensor;

import com.example.simulator.utils.random.RandomGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalinitySensor {
    private Double value;

    public SalinitySensor() {
        this.value = RandomGenerator.generateRandomDoubleFromRange(-1, 0);
    }
}
