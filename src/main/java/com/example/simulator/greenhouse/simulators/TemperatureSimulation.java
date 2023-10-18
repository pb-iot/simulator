package com.example.simulator.greenhouse.simulators;

import com.example.simulator.greenhouse.devices.airConditioning.AirConditioning;
import com.example.simulator.greenhouse.sensors.temperatureSensor.TemperatureSensor;
import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.CurrentWeather;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDouble;

public class TemperatureSimulation implements Simulable {
    private final double RANGE_MIN_TEMP = 0.05;
    private final double RANGE_MAX_TEMP = 0.40;
    private final double GROWN_TEMP_BONUS = 1.5;

    private final AirConditioning airConditioning = new AirConditioning();

    private final TemperatureSensor temperatureSensor = new TemperatureSensor();

    @Override
    public void triggerSimulation() {
        double changeTemperature = getSensorChange() + getACChange();

        temperatureSensor.setValue(temperatureSensor.getValue() + changeTemperature);
    }

    private double getSensorChange() {
        WeatherForecast weatherForecast = new WeatherForecast();
        CurrentWeather currentWeather = weatherForecast.getActualTemperature();

        double changeTemperature = generateRandomDouble(RANGE_MIN_TEMP, RANGE_MAX_TEMP);


        if (currentWeather.getIsDay() == 1) { /* is day */
            if (currentWeather.getTemperature2m() > temperatureSensor.getValue())
                return temperatureSensor.getValue() + (changeTemperature * GROWN_TEMP_BONUS);
            else
                return temperatureSensor.getValue() + (changeTemperature * -1);
        } else { /* is night */
            if (currentWeather.getTemperature2m() > temperatureSensor.getValue())
                return temperatureSensor.getValue() + changeTemperature;
            else
                return temperatureSensor.getValue() + (changeTemperature * -1 * GROWN_TEMP_BONUS);
        }
    }

    private double getACChange() {
        double randomTemperature = generateRandomDouble(RANGE_MIN_TEMP, RANGE_MAX_TEMP) * airConditioning.getPowerLevel().getGrownBonus();

        return randomTemperature * airConditioning.getAction().getAction();
    }

    @Override
    public Double getSimulatedValue() {
        return temperatureSensor.getValue();
    }
}
