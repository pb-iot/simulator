package com.example.simulator.greenhouse.temperature.devices.temperatureSensor;

import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.CurrentWeather;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDouble;

@Component
public class TemperatureSensorSimulator {

    private final double RANGE_MIN_TEMP = 0.05;
    private final double RANGE_MAX_TEMP = 0.40;
    private final double GROWN_TEMP_BONUS = 1.5;

    @Scheduled(fixedRate = 5 * 60000) // for 5 minutes
    public void scheduledTask() {
        List<Greenhouse> greenhouseList = GreenhousesData.getInstance().getGreenhouseList();

        greenhouseList.forEach(greenhouse -> {
            TemperatureSensor temperatureSensor = greenhouse.getTemperature().getTemperatureSensor();
            double temperatureInGreenhouse = temperatureSensor.getValue();

            WeatherForecast weatherForecast = new WeatherForecast();
            CurrentWeather currentWeather = weatherForecast.getActualTemperature();

            double randomTemperature = generateRandomDouble(RANGE_MIN_TEMP, RANGE_MAX_TEMP);

            if(currentWeather.getIsDay() == 1) { /* is day */
                if(currentWeather.getTemperature2m() > temperatureInGreenhouse)
                    temperatureSensor.setValue(temperatureInGreenhouse + (randomTemperature * GROWN_TEMP_BONUS));
                else
                    temperatureSensor.setValue(temperatureInGreenhouse + (randomTemperature * -1 ));
            } else { /* is night */
                if(currentWeather.getTemperature2m() > temperatureInGreenhouse)
                    temperatureSensor.setValue(temperatureInGreenhouse + (randomTemperature));
                else
                    temperatureSensor.setValue(temperatureInGreenhouse + (randomTemperature * -1 * GROWN_TEMP_BONUS));
            }
        });
    }



}
