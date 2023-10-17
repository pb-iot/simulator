package com.example.simulator.greenhouse.temperature.devices.temperatureSensor;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
public class TemperatureHistory {
    private double temperature;

    private Timestamp timestamp = Timestamp.from(Instant.now());

    public TemperatureHistory(double temperature){
        this.temperature = temperature;
    }
}
