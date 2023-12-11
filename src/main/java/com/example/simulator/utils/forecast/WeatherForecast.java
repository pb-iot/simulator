package com.example.simulator.utils.forecast;

import com.example.simulator.exceptions.api.WeatherForecastException;
import com.example.simulator.utils.forecast.data.CurrentWeather;
import com.example.simulator.utils.forecast.data.WeatherData;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class WeatherForecast {

    public static final String urlForecast = "https://api.open-meteo.com/v1/forecast";

    // TODO: latitude and longitude move to greenhouse
    public static final Double latitude = 25.2744; // 53.1221 - Białystok, 25.2744 - Australia
    public static final Double longitude = 133.7751; // 23.1443 - Białystok, 133.7751 - Australia


    public CurrentWeather getActualTemperature() {
        try{
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            HttpResponse<String> response = Unirest.get(urlForecast)
                    .queryString("latitude", latitude)
                    .queryString("longitude", longitude)
                    .queryString("current", "temperature_2m,apparent_temperature,is_day")
                    .asString();

            String stringBody = response.getBody();
            WeatherData weatherData = gson.fromJson(stringBody, WeatherData.class);
            return weatherData.getCurrent();
        } catch (Exception e){
            e.printStackTrace();
        }
        throw new WeatherForecastException();
    }

    public CurrentWeather getHumidity() {
        try{
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            HttpResponse<String> response = Unirest.get(urlForecast)
                    .queryString("latitude", latitude)
                    .queryString("longitude", longitude)
                    .queryString("current", "relative_humidity_2m")
                    .asString();

            String stringBody = response.getBody();
            WeatherData weatherData = gson.fromJson(stringBody, WeatherData.class);
            return weatherData.getCurrent();
        } catch (Exception e){
            e.printStackTrace();
        }
        throw new WeatherForecastException();
    }
    public CurrentWeather getParData() {
        try{
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            HttpResponse<String> response = Unirest.get(urlForecast)
                    .queryString("latitude", latitude)
                    .queryString("longitude", longitude)
                    .queryString("current", "shortwave_radiation,direct_radiation,diffuse_radiation")
                    .asString();

            String stringBody = response.getBody();
            WeatherData weatherData = gson.fromJson(stringBody, WeatherData.class);
            return weatherData.getCurrent();
        } catch (Exception e){
            e.printStackTrace();
        }
        throw new WeatherForecastException();
    }

}
