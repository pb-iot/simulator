package com.example.simulator.greenhouse.simulators;

import com.example.simulator.DTOs.UpdateHumidifierDTO;
import com.example.simulator.greenhouse.devices.humidifier.Humidifier;
import com.example.simulator.greenhouse.sensors.humiditySensor.HumiditySensor;
import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.CurrentWeather;

import java.util.Objects;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDoubleFromRange;

public class HumiditySimulation implements Simulable {
    private final double RANGE_MIN = 0.05;
    private final double RANGE_MAX = 0.40;

    private final Humidifier humidifier = new Humidifier();

    private final HumiditySensor sensor = new HumiditySensor();


    @Override
    public void triggerSimulation() {
        double changeHumidity = getSensorChange() + getHumidifierChange();

        if (sensor.getValue() + changeHumidity > 100) {
            sensor.setValue(100d);
        } else if (sensor.getValue() + changeHumidity < 0) {
            sensor.setValue(0d);
        } else {
            sensor.setValue(sensor.getValue() + changeHumidity);
        }
    }

    private double getSensorChange() {
        WeatherForecast weatherForecast = new WeatherForecast();
        CurrentWeather currentWeather = weatherForecast.getHumidity();

        double changeTemperature = generateRandomDoubleFromRange(RANGE_MIN, RANGE_MAX);

        if (currentWeather.getHumidity2m() > sensor.getValue()) {
            return changeTemperature;
        } else {
            return changeTemperature * -1;
        }
    }

    private double getHumidifierChange() {
        return generateRandomDoubleFromRange(RANGE_MIN, RANGE_MAX) * humidifier.getPowerLevel().getGrownBonus();
    }

    public void setHumidifierValue(UpdateHumidifierDTO dto) {
        if (Objects.nonNull(dto.getPowerLevel()))
            humidifier.setPowerLevel(dto.getPowerLevel());
    }

    @Override
    public Double getSimulatedValue() {
        return sensor.getValue();
    }
}
