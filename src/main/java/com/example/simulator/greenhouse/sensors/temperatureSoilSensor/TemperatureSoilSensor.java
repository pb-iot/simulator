package com.example.simulator.greenhouse.sensors.temperatureSoilSensor;

import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.HourlyData;
import lombok.Getter;

import static com.example.simulator.utils.random.Calculator.calculateAverage;

@Getter
public class TemperatureSoilSensor {
    private final static Double MIN = -10.00;
    private final static Double MAX = 40.00;

    private Double value;

    public TemperatureSoilSensor() {
        WeatherForecast weatherForecast = new WeatherForecast();
        HourlyData hourlyData = weatherForecast.getSoilTemperature();

        setValue(calculateAverage(hourlyData.getSoilTemperature6cm()));
    }

    public void setValue(double value) {
        if (value >= MIN && value <= MAX)
            this.value = value;
    }
}
