package com.example.simulator.greenhouse.devices.humidifier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Humidifier {
    private HumidifierPowerLevel powerLevel = HumidifierPowerLevel.OFF;
}
