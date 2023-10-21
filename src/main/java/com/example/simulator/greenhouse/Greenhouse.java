package com.example.simulator.greenhouse;

import com.example.simulator.DTOs.SensorValueDTO;
import com.example.simulator.exceptions.basic.BasicBadRequestException;
import com.example.simulator.greenhouse.simulators.Simulable;
import com.example.simulator.greenhouse.simulators.SimulationType;
import lombok.Getter;

import java.util.HashMap;
import java.util.Objects;

import static com.example.simulator.configurations.response.ResponseMessage.ALREADY_INSTALLED;
import static com.example.simulator.configurations.response.ResponseMessage.NO_SENSOR;

@Getter
public class Greenhouse {

    private final HashMap<SimulationType, Simulable> simulations = new HashMap<>();

    public Greenhouse() {
//        simulations.put(SimulationType.TEMPERATURE, new TemperatureSimulation());
    }

    public void simulateAll() {
        for (Simulable simulation : simulations.values()) {
            simulation.triggerSimulation();
        }
    }

    public void install(SimulationType simulationType) {
        Simulable simulable = simulations.get(simulationType);
        if (Objects.nonNull(simulable))
            throw new BasicBadRequestException(ALREADY_INSTALLED);

        simulations.put(simulationType, simulationType.install());
    }

    public void breakup(SimulationType simulationType) {
        Simulable simulable = simulations.get(simulationType);
        if (Objects.isNull(simulable))
            throw new BasicBadRequestException(NO_SENSOR);

        simulations.remove(simulationType);
    }

    public SensorValueDTO getSensorsValue(SimulationType simulationType) {
        Simulable simulable = simulations.get(simulationType);
        if (Objects.isNull(simulable))
            throw new BasicBadRequestException(NO_SENSOR);

        return SensorValueDTO.builder()
                .value(simulable.getSimulatedValue())
                .build();
    }
}
