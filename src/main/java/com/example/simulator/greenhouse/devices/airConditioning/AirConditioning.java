package com.example.simulator.greenhouse.devices.airConditioning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirConditioning {
    public final static double MAX_TEMPERATURE = 40.00;
    public final static double MIN_TEMPERATURE = -10.00;

    private AirConditioningPowerLevel powerLevel = AirConditioningPowerLevel.OFF;

    private AirConditioningAction action = AirConditioningAction.HEAT;
}
