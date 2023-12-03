package com.example.simulator.DTOs;

import com.example.simulator.greenhouse.devices.water.WaterAction;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WaterDTO {

    private WaterAction waterAction;
}
