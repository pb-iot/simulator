package com.example.simulator.simulation;

import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class SimulatorService {

    @Scheduled(cron = "0/1 * * * * *")
    public void simulate() {
        GreenhousesData greenhousesData = GreenhousesData.getInstance();
        greenhousesData.getGreenhouseList().values()
                .forEach(Greenhouse::simulateAll);
    }

//    private double increaseTemperature(){
//
//    }
}
