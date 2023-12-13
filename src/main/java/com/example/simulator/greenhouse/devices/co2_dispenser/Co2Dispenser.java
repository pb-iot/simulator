package com.example.simulator.greenhouse.devices.co2_dispenser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Co2Dispenser {
    private Co2DispenserState state = Co2DispenserState.OFF;
}
