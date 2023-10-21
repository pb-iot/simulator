package com.example.simulator.utils.forecast;

import com.example.simulator.utils.forecast.data.CurrentWeather;
import com.example.simulator.utils.forecast.data.WeatherData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class WeatherForecast {

    public static final String urlForecast = "https://api.open-meteo.com/v1/forecast";

    public static final Double latitude = 53.1221;
    public static final Double longitude = 23.1443;


    public CurrentWeather getActualTemperature() {
        try{
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            HttpResponse<String> response = Unirest.get("https://api.open-meteo.com/v1/forecast")
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
        return null;
    }
}