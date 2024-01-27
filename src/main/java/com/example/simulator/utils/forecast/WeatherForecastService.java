package com.example.simulator.utils.forecast;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastService {

    @Scheduled(cron = "0 * * * * ?") //o każdej pełnej minucie
    public void updateWeatherDataFromAPI() {
        WeatherForecast.updateWeatherDataFromAPI();
    }
}
