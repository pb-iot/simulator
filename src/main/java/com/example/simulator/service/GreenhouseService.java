package com.example.simulator.service;

import com.example.simulator.DTOs.*;
import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import com.example.simulator.greenhouse.simulators.*;
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

    public void setWaterLevel(Integer greenhouseId, WaterDTO dto) {
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        WaterSimulation simulation = (WaterSimulation) greenhouse.getSimulation(SimulationType.WATER);
        simulation.setWaterLevel(dto);
    }

    public void setLight(Integer greenhouseId, LightDTO dto){
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        ParSimulation simulation = (ParSimulation) greenhouse.getSimulation(SimulationType.PAR);
        simulation.setLightSwitch(dto);
    }

    public void setSalinityValue(Integer greenhouseId, UpdateSalinityDeviceDTO dto){
        Greenhouse greenhouse = GreenhousesData.getInstance().getGreenhouse(greenhouseId);

        SalinitySimulation simulation = (SalinitySimulation) greenhouse.getSimulation(SimulationType.SALINITY);
        simulation.setSalinityDeviceState(dto);
    }
}