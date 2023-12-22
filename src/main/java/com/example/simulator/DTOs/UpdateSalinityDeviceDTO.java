package com.example.simulator.DTOs;

import com.example.simulator.greenhouse.devices.salinity.SalinityDeviceState;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSalinityDeviceDTO {
    private SalinityDeviceState state;
}
