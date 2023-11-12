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
public class CurrentUnits {
    private String time;
    private String interval;
    @SerializedName("temperature_2m")
    private String temperature2m;
    @SerializedName("relative_humidity_2m")
    private String humidity2m;
    private String apparentTemperature;
    private String isDay;
}