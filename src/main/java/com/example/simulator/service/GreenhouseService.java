package com.example.simulator.service;

import com.example.simulator.DTOs.AirConditioningDTO;
import com.example.simulator.DTOs.SensorValueDTO;
import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import com.example.simulator.greenhouse.simulators.SimulationType;
import com.example.simulator.greenhouse.simulators.TemperatureSimulation;
import org.springframework.stereotype.Service;

@Service
public class GreenhouseService {


    public void installSimulation(Integer greenhouseId, SimulationType type) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        greenhouse.install(type);
    }


    public void breakupSimulation(Integer greenhouseId, SimulationType type) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        greenhouse.breakup(type);
    }

    public SensorValueDTO getSimulationValue(Integer greenhouseId, SimulationType type) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        return greenhouse.getSensorsValue(type);
    }

    public void setTemperatureSimulation(Integer greenhouseId, AirConditioningDTO airConditioningDTO) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        TemperatureSimulation temperatureSimulation = (TemperatureSimulation) greenhouse.getSimulation(SimulationType.TEMPERATURE);
        temperatureSimulation.setAC(airConditioningDTO);
    }


}