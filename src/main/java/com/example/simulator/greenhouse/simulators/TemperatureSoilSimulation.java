package com.example.simulator.greenhouse.simulators;

import com.example.simulator.DTOs.UnderfloorHeatingDTO;
import com.example.simulator.greenhouse.devices.underfloorHeating.UnderfloorHeating;
import com.example.simulator.greenhouse.sensors.temperatureSoilSensor.TemperatureSoilSensor;
import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.HourlyData;

import static com.example.simulator.utils.random.Calculator.calculateAverage;
import static com.example.simulator.utils.random.RandomGenerator.generateRandomDoubleFromRange;

public class TemperatureSoilSimulation implements Simulable {
    private final double RANGE_MIN_TEMP = 0.05;
    private final double RANGE_MAX_TEMP = 0.40;
    private final double GROWN_TEMP_BONUS = 1.5;
    private final double CHANCE_BONUS = 10; // %
    private final double CHANCE_CHANGE_SIGN = 10; // %

    private final UnderfloorHeating device = new UnderfloorHeating();
    private final TemperatureSoilSensor sensor = new TemperatureSoilSensor();

    @Override
    public void triggerSimulation() {
        double changeTemperature = getSensorChange() + getDeviceChange();

        sensor.setValue(sensor.getValue() + changeTemperature);
    }

    private double getSensorChange() {
        WeatherForecast weatherForecast = new WeatherForecast();
        HourlyData hourlyData = weatherForecast.getSoilTemperature();
        double currentSoilTemperature = calculateAverage(hourlyData.getSoilTemperature6cm());

        double changeTemperature = generateRandomDoubleFromRange(RANGE_MIN_TEMP, RANGE_MAX_TEMP);

        if (currentSoilTemperature < sensor.getValue())
            changeTemperature = changeTemperature * -1;
        if (generateRandomDoubleFromRange(0, 100) <= CHANCE_BONUS)
            changeTemperature = changeTemperature * GROWN_TEMP_BONUS;
        if (generateRandomDoubleFromRange(0, 100) <= CHANCE_CHANGE_SIGN)
            changeTemperature = changeTemperature * -1;

        return changeTemperature;
    }

    private double getDeviceChange() {
        return generateRandomDoubleFromRange(RANGE_MIN_TEMP, RANGE_MAX_TEMP) * device.getState().getState();
    }

    @Override
    public Double getSimulatedValue() {
        return sensor.getValue();
    }

    public void setUnderfloorHeatingOptions(UnderfloorHeatingDTO underfloorHeatingDTO) {
        device.setState(underfloorHeatingDTO.getState());
    }
}
