package com.example.simulator.DTOs;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirTemperatureDTO {

    private SensorValueDTO sensor;

    private AirConditioningDTO airConditioning;
}
