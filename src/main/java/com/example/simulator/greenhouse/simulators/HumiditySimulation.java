package com.example.simulator.greenhouse.simulators;

import com.example.simulator.DTOs.AirConditioningDTO;
import com.example.simulator.greenhouse.devices.airConditioning.AirConditioning;
import com.example.simulator.greenhouse.devices.humidifier.Humidifier;
import com.example.simulator.greenhouse.sensors.humiditySensor.HumiditySensor;
import com.example.simulator.greenhouse.sensors.temperatureSensor.TemperatureSensor;
import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.CurrentWeather;

import java.util.Objects;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDoubleFromRange;

public class HumiditySimulation implements Simulable {

    private final Humidifier humidifier = new Humidifier();

    private final HumiditySensor sensor = new HumiditySensor();


    @Override
    public void triggerSimulation() {
        double changeHumidity = getSensorChange() + getHumidifierChange();

        sensor.setValue(sensor.getValue() + changeHumidity);
    }

    private double getSensorChange() {
        WeatherForecast weatherForecast = new WeatherForecast();
        CurrentWeather currentWeather = weatherForecast.getHumidity();

        return 0;
    }

    private double getHumidifierChange() {
        return 0;
    }

    public void setHumidifierValue() {
    }

    @Override
    public Double getSimulatedValue() {
        return sensor.getValue();
    }
}
