package com.example.simulator.greenhouse.sensors.humiditySensor;

import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.CurrentWeather;
import lombok.Getter;

@Getter
public class HumiditySensor {
    private double value;

    public HumiditySensor() {
        WeatherForecast weatherForecast = new WeatherForecast();
        CurrentWeather currentWeather = weatherForecast.getHumidity();

        this.value = currentWeather.getHumidity2m();
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
