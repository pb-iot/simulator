package com.example.simulator.data;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Measurements {
    private LocalDateTime timestamp;
    private Double airTemperature;
    private Double humidity;
    private Double parLevel;
    private Double co2;
    private Double substrateWaterLevel;
    private Double salinityLevel;
    private Double substrateTemperature;
    private Double substrateWeight;
    private Double plantWeight;
    private Double stemVariability;

}
