package com.example.simulator.DTOs;

import com.example.simulator.greenhouse.devices.humidifier.HumidifierPowerLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHumidifierDTO {
    private HumidifierPowerLevel powerLevel;
}
