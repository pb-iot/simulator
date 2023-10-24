package com.example.simulator.greenhouse.sensors.temperatureSensor;

import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.CurrentWeather;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TemperatureSensor {

    private final int LIMIT_HISTORY_SIZE = 100;

    private final List<TemperatureHistoryEntry> temperatureHistory = new ArrayList<>();
    private double value;

    public TemperatureSensor() {
        WeatherForecast weatherForecast = new WeatherForecast();
        CurrentWeather currentWeather = weatherForecast.getActualTemperature();

        this.value = currentWeather.getTemperature2m();
        addTemperatureHistoryEntry(this.value);
    }

    public void setValue(Double value) {
        this.value = value;
        addTemperatureHistoryEntry(value);
    }

    private void addTemperatureHistoryEntry(double temperature){
        if(temperatureHistory.size() >= LIMIT_HISTORY_SIZE)
            temperatureHistory.remove(0);

        temperatureHistory.add(new TemperatureHistoryEntry(temperature));
    }
}
