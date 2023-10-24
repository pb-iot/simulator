package com.example.simulator.greenhouse;

import com.example.simulator.DTOs.SensorValueDTO;
import com.example.simulator.exceptions.basic.BasicBadRequestException;
import com.example.simulator.greenhouse.simulators.Simulable;
import com.example.simulator.greenhouse.simulators.SimulationType;
import lombok.Getter;

import java.util.HashMap;
import java.util.Objects;

import static com.example.simulator.configurations.response.ResponseMessage.SIMULATION_ALREADY_ADDED;
import static com.example.simulator.configurations.response.ResponseMessage.SIMULATION_OF_GIVEN_TYPE_DOES_NOT_EXIST;

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

    public void addSimulation(SimulationType simulationType) {
        Simulable simulable = simulations.get(simulationType);

        //Jeśli taka symulacja już istnieje, to rzucamy wyjątek
        if (Objects.nonNull(simulable)) {
            throw new BasicBadRequestException(SIMULATION_ALREADY_ADDED);
        }

        simulations.put(simulationType, simulationType.getSimulable());
    }

    public void deleteSimulation(SimulationType simulationType) {
        getSimulation(simulationType);

        simulations.remove(simulationType);
    }

    public SensorValueDTO getSensorsValue(SimulationType simulationType) {
        Simulable simulable = getSimulation(simulationType);

        return SensorValueDTO.builder()
                .value(simulable.getSimulatedValue())
                .build();
    }

    public Simulable getSimulation(SimulationType simulationType) {
        Simulable simulable = simulations.get(simulationType);

        //Jeśli nie istnieje taka symulacja, to rzucamy wyjątek
        if (Objects.isNull(simulable)) {
            throw new BasicBadRequestException(SIMULATION_OF_GIVEN_TYPE_DOES_NOT_EXIST);
        }
        return simulable;
    }
}
