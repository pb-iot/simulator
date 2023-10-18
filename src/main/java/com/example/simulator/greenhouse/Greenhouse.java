package com.example.simulator.greenhouse;

import com.example.simulator.greenhouse.simulators.Simulable;
import com.example.simulator.greenhouse.simulators.TemperatureSimulation;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class Greenhouse {

    private final HashMap<String, Simulable> simulations = new HashMap<>();

    public Greenhouse() {
        simulations.put("temperature", new TemperatureSimulation());

    }

    public void simulateAll() {
        for (Simulable simulation : simulations.values()) {
            simulation.triggerSimulation();
        }
    }

//    private Temperature temperature = new Temperature();
}
