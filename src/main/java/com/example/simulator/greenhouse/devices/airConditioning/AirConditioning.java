package com.example.simulator.greenhouse.devices.airConditioning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirConditioning {

    private AirConditioningPowerLevel powerLevel = AirConditioningPowerLevel.OFF;

    private AirConditioningAction action = AirConditioningAction.HEAT;
}
