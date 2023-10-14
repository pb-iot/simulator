package com.example.simulator.data;

import com.example.simulator.data.sensors.TemperatureSimulation;
import lombok.Data;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

@Data
public class Greenhouse {
    private HashMap<String, DoubleSimulation> simulations = new HashMap<String, DoubleSimulation>();

    public Greenhouse() {
        simulations.put("temperature", new TemperatureSimulation(20d, 20d));
        //simulations.add(new HumiditySimulation());
        //...
    }

    public void simulateAll() {
        for (DoubleSimulation simulation : simulations.values()) {
            simulation.triggerSimulation();
        }
    }

    public HashMap<String, Double> GetCurrentMeasurements() {
        HashMap<String, Double> measurements = new HashMap<>();

        for (String simulationName : simulations.keySet()) {
            measurements.put(simulationName, simulations.get(simulationName).getSimulatedValue());
        }

        return measurements;
    }
}
