package com.example.simulator.DTOs;

import com.example.simulator.greenhouse.devices.underfloorHeating.UnderfloorHeatingState;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnderfloorHeatingDTO {
    @NotNull
    private UnderfloorHeatingState state;
}
