package com.example.simulator.service;

import com.example.simulator.DTOs.AirConditioningDTO;
import com.example.simulator.DTOs.SensorValueDTO;
import com.example.simulator.DTOs.UpdateHumidifierDTO;
import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import com.example.simulator.greenhouse.simulators.HumiditySimulation;
import com.example.simulator.greenhouse.simulators.SimulationType;
import com.example.simulator.greenhouse.simulators.TemperatureSimulation;
import org.springframework.stereotype.Service;

@Service
public class GreenhouseService {


    public void addSimulation(Integer greenhouseId, SimulationType type) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        greenhouse.addSimulation(type);
    }


    public void deleteSimulation(Integer greenhouseId, SimulationType type) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        greenhouse.deleteSimulation(type);
    }

    public SensorValueDTO getSimulationValue(Integer greenhouseId, SimulationType type) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        return greenhouse.getSensorsValue(type);
    }

    public void setAirConditioningValue(Integer greenhouseId, AirConditioningDTO airConditioningDTO) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        TemperatureSimulation temperatureSimulation = (TemperatureSimulation) greenhouse.getSimulation(SimulationType.TEMPERATURE);
        temperatureSimulation.setAirConditioningValue(airConditioningDTO);
    }

    public void setHumidityValue(Integer greenhouseId, UpdateHumidifierDTO dto) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        HumiditySimulation simulation = (HumiditySimulation) greenhouse.getSimulation(SimulationType.HUMIDITY);
        simulation.setHumidifierValue(dto);
    }
}