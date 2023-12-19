package com.example.simulator.greenhouse.devices.salinity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalinityDevice {
    private SalinityDeviceState state = SalinityDeviceState.OFF;
}
