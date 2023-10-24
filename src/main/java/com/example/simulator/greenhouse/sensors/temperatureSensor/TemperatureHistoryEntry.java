package com.example.simulator.greenhouse.sensors.temperatureSensor;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
public class TemperatureHistoryEntry {
    private double temperature;

    private Timestamp timestamp = Timestamp.from(Instant.now());

    public TemperatureHistoryEntry(double temperature){
        this.temperature = temperature;
    }
}
