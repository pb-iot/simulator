package com.example.simulator.data;

import com.example.simulator.DTOs.AirTemperatureDTO;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Measurements {
    private LocalDateTime timestamp;
    private AirTemperatureDTO airTemperature;


    /*
    private Double humidity;
    private Double parLevel;
    private Double co2;
    private Double substrateWaterLevel;
    private Double salinityLevel;
    private Double substrateTemperature;
    private Double substrateWeight;
    private Double plantWeight;
    private Double stemVariability;

    */

}
