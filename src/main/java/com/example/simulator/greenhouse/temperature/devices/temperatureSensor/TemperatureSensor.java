package com.example.simulator.greenhouse.temperature.devices.temperatureSensor;

import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.CurrentWeather;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TemperatureSensor {

    private final int LIMIT_HISTORY_SIZE = 100;

    private final List<TemperatureHistory> temperatureHistories = new ArrayList<>();
    private double value;

    public TemperatureSensor() {
        WeatherForecast weatherForecast = new WeatherForecast();
        CurrentWeather currentWeather = weatherForecast.getActualTemperature();

        this.value = currentWeather.getTemperature2m();
        addTemperatureHistory(this.value);
    }

    public void setValue(Double value) {
        this.value = value;
        addTemperatureHistory(value);
    }

    private void addTemperatureHistory(double temperature){
        if(temperatureHistories.size() >= LIMIT_HISTORY_SIZE)
            temperatureHistories.remove(0);

        temperatureHistories.add(new TemperatureHistory(temperature));
    }
}
