package com.example.simulator.greenhouse.devices.light;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Light {

    private LightState state = LightState.OFF;
}
