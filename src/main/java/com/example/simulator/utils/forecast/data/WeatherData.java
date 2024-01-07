package com.example.simulator.utils.forecast.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    private double latitude;
    private double longitude;
    private double generationTimeMs;
    private double utcOffsetSeconds;
    private String timezone;
    private String timezoneAbbreviation;
    private double elevation;

    private HourlyData hourly;
    private CurrentUnits currentUnits;
    private CurrentWeather current;
}
