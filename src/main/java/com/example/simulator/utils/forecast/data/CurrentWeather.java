package com.example.simulator.utils.forecast.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeather {
    private String time;
    private int interval;
    private double temperature2m;
    private double apparentTemperature;
    private int isDay;
}