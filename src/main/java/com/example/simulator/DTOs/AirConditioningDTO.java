package com.example.simulator.DTOs;

import com.example.simulator.greenhouse.devices.airConditioning.AirConditioningAction;
import com.example.simulator.greenhouse.devices.airConditioning.AirConditioningPowerLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AirConditioningDTO {

    private AirConditioningPowerLevel powerLevel;

    private AirConditioningAction action;
}
