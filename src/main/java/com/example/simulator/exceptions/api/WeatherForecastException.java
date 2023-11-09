package com.example.simulator.exceptions.api;

import com.example.simulator.exceptions.basic.BasicFailedDependencyException;

import static com.example.simulator.configurations.response.ResponseMessage.API_WEATHER_NOT_WORK;

public class WeatherForecastException extends BasicFailedDependencyException {

    public WeatherForecastException() {
        super(API_WEATHER_NOT_WORK);
    }
}
