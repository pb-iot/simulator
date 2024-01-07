package com.example.simulator.DTOs;

import com.example.simulator.greenhouse.devices.co2_dispenser.Co2DispenserState;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Co2DispenserDTO {
    private Co2DispenserState co2DispenserState;
}
