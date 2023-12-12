package com.example.simulator.greenhouse.sensors.parSensor;

import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.CurrentWeather;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParSensor {
    
    private double parValue;

    public ParSensor() {
        updateParValue();
    }

    public void updateParValue() {
        WeatherForecast weatherForecast = new WeatherForecast();
        CurrentWeather currentWeather = weatherForecast.getParData();

        double parShortwave = currentWeather.getShortwaveRadiation();

        // direct_radiation - Preceding 15 minutes mean - W/m²
        double parDirect = currentWeather.getDirectRadiation();

        // diffuse_radiation - Preceding 15 minutes mean - W/m²
        double parDiffuse = currentWeather.getDiffuseRadiation();

        parValue = parShortwave + parDirect + parDiffuse;
    }
}
