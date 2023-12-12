package com.example.simulator.DTOs;

import com.example.simulator.greenhouse.devices.light.Light;
import com.example.simulator.greenhouse.devices.light.LightState;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LightDTO {
    private LightState lightState;
}
