package com.example.simulator.utils.forecast.data;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HourlyData {

    @SerializedName("soil_temperature_6cm")
    private List<Double> soilTemperature6cm = new ArrayList<>();
}
