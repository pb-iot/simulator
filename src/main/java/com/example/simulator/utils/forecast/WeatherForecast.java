package com.example.simulator.utils.forecast;

import com.example.simulator.exceptions.api.WeatherForecastException;
import com.example.simulator.utils.forecast.data.CurrentWeather;
import com.example.simulator.utils.forecast.data.HourlyData;
import com.example.simulator.utils.forecast.data.WeatherData;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class WeatherForecast {

    public static final String urlForecast = "https://api.open-meteo.com/v1/forecast";

    public static final Double latitude = 53.1221; // 53.1221 - Białystok, 25.2744 - Australia
    public static final Double longitude = 23.1443; // 23.1443 - Białystok, 133.7751 - Australia

    public static WeatherData weatherData = null;

    public static void updateWeatherDataFromAPI() {
        try {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            HttpResponse<String> response = Unirest.get(urlForecast)
                                                   .queryString("latitude", latitude)
                                                   .queryString("longitude", longitude)
                                                   .queryString("current",
                                                                "temperature_2m,"
                                                                        + "apparent_temperature,"
                                                                        + "is_day,"
                                                                        + "relative_humidity_2m,"
                                                                        + "shortwave_radiation,"
                                                                        + "direct_radiation,"
                                                                        + "diffuse_radiation")
                                                   .queryString("hourly", "soil_temperature_6cm")
                                                   .asString();

            String stringBody = response.getBody();
            weatherData = gson.fromJson(stringBody, WeatherData.class);
        } catch (Exception e) {
            throw new WeatherForecastException();
        }
    }

    public CurrentWeather getActualTemperature() {
        if (weatherData == null) {
            updateWeatherDataFromAPI();
        }

        return weatherData.getCurrent();
    }

    public CurrentWeather getHumidity() {
        if (weatherData == null) {
            updateWeatherDataFromAPI();
        }

        return weatherData.getCurrent();
    }

    public CurrentWeather getParData() {
        if (weatherData == null) {
            updateWeatherDataFromAPI();
        }

        return weatherData.getCurrent();
    }

    public HourlyData getSoilTemperature() {
        if (weatherData == null) {
            updateWeatherDataFromAPI();
        }

        return weatherData.getHourly();
    }
}
