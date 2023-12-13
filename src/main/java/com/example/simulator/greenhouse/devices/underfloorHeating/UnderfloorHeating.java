package com.example.simulator.greenhouse.devices.underfloorHeating;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnderfloorHeating {
    private UnderfloorHeatingState state = UnderfloorHeatingState.OFF;
}
