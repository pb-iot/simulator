package com.example.simulator.greenhouse.simulators;

import com.example.simulator.DTOs.UpdateSalinityDeviceDTO;
import com.example.simulator.greenhouse.devices.salinity.SalinityDevice;
import com.example.simulator.greenhouse.devices.salinity.SalinityDeviceState;
import com.example.simulator.greenhouse.sensors.salinitySensor.SalinitySensor;
import com.example.simulator.utils.random.RandomGenerator;

import java.util.Objects;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDoubleFromRange;

public class SalinitySimulation implements Simulable {
    private final double DEVICE_RANGE_MIN = 1;
    private final double DEVICE_RANGE_MAX = 3;

    private final SalinitySensor sensor = new SalinitySensor();

    private final SalinityDevice device = new SalinityDevice();

    @Override
    public void triggerSimulation() {
        double sensorChange = getSensorChange() + getDeviceChange();

        if (sensor.getValue() + sensorChange > 20000) {
            sensor.setValue(20000d);
        } else if (sensor.getValue() + sensorChange < 0) {
            sensor.setValue(0d);
        } else {
            sensor.setValue(sensor.getValue() + sensorChange);
        }
    }

    @Override
    public Double getSimulatedValue() {
        return sensor.getValue();
    }

    public void setSalinityDeviceState(UpdateSalinityDeviceDTO dto) {
        if (Objects.nonNull(dto.getState()))
            device.setState(dto.getState());
    }

    private double getSensorChange() {
        return RandomGenerator.generateRandomDoubleFromRange(-1, 0);
    }

    private double getDeviceChange() {
        if(device.getState().getState() == SalinityDeviceState.ON.getState()) {
            return generateRandomDoubleFromRange(DEVICE_RANGE_MIN, DEVICE_RANGE_MAX);
        }

        return 0;
    }
}
