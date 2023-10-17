package com.example.simulator.utils.forecast.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUnits {
    private String time;
    private String interval;
    private String temperature2m;
    private String apparentTemperature;
    private String isDay;
}