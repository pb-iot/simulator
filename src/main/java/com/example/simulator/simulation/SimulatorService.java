package com.example.simulator.simulation;

import com.example.simulator.data.Greenhouse;
import com.example.simulator.data.Measurements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

@Service
public class SimulatorService {

    private List<Greenhouse> greenhouseList = new ArrayList<>();

    @Scheduled(cron = "0/1 * * * * *")
    public void fluctuate() {
        greenhouseList.getFirst().fluctuate();
    }

    public Measurements getCurrentMeasurements(int greenhouseId) {
        return Measurements.builder()
                .timestamp(LocalDateTime.now())
                .temperature(getCurrentTemperature(greenhouseId))
                //.humidity(getCurrentHumidity(greenhouseId))
                //...
                .build();
    }

    private double getCurrentTemperature(int greenhouseId) {
        Random random = new Random();
        return round(19 + random.nextDouble() * 2, 1);//generowanie liczb z zakresu od 19 do 21; docelowo do zmiany
    }

    /*private double getCurrentHumidity(int greenhouseId) {
        Random random = new Random();
        return round(20 + random.nextDouble(), 1);
    }*/

    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
