package com.example.simulator.utils.forecast.data;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName("temperature_2m")
    private double temperature2m;
    @SerializedName("relative_humidity_2m")
    private double humidity2m;
    private double apparentTemperature;
    private int isDay;
}