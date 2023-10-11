package com.example.simulator.data;

import com.example.simulator.data.sensors.Temperature;
import lombok.Data;

@Data
public class Greenhouse {
    private Temperature temperature;
    // other sensors

    public void fluctuate() {
        temperature.fluctuate();
    }
}
