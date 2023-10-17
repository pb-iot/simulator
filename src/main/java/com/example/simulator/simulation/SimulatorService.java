package com.example.simulator.simulation;

import com.example.simulator.data.Greenhouse;
import com.example.simulator.data.Measurements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

@Service
public class SimulatorService {

    private HashMap<Integer, Greenhouse> greenhouses = new HashMap<>();

    public SimulatorService() {
        greenhouses.put(0, new Greenhouse());
    }

    @Scheduled(cron = "0/1 * * * * *")
    public void simulate() {
        for (Greenhouse greenhouse : greenhouses.values()) {
            greenhouse.simulateAll();
        }
    }

    public Measurements getCurrentMeasurements(int greenhouseId) {
        return new Measurements(LocalDateTime.now(), greenhouses.get(greenhouseId).GetCurrentMeasurements());
    }

    public Greenhouse getGreenhouse(Integer id) {
        return greenhouses.get(id);
    }
}
