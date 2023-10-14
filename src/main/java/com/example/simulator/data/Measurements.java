package com.example.simulator.data;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;

@Data
@AllArgsConstructor
public class Measurements {
    private LocalDateTime timestamp;
    private HashMap<String, Double> measurements;

    //private Double airTemperature;
    //private Double humidity;
    //private Double parLevel;
    //private Double co2;
    //private Double substrateWaterLevel;
    //private Double salinityLevel;
    //private Double substrateTemperature;
    //private Double substrateWeight;
    //private Double plantWeight;
    //private Double stemVariability;

}
