package com.example.simulator.greenhouse.simulators;

import java.util.Objects;

import com.example.simulator.DTOs.Co2DispenserDTO;
import com.example.simulator.greenhouse.devices.co2_dispenser.Co2Dispenser;
import com.example.simulator.greenhouse.devices.co2_dispenser.Co2DispenserState;
import com.example.simulator.greenhouse.sensors.co2Sensor.Co2Sensor;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDoubleFromRange;

public class Co2Simulation implements Simulable {

    private final double MIN_VALUE = 400;
    private final double MAX_VALUE = 2000; // 2000 ppm to o 800 za duża wartość, niż być powinna, ale potencjalnie mogłaby taka wystąpić
    private final Co2Sensor co2Sensor = new Co2Sensor();
    private final Co2Dispenser co2Dispenser = new Co2Dispenser();

    @Override
    public void triggerSimulation() {
        co2Sensor.updateCo2Value();
        double simulatedValue = co2Sensor.getCo2Ppm() + getCo2Change();

        double newValue = Math.max(simulatedValue, MIN_VALUE);
        newValue = Math.min(newValue, MAX_VALUE);

        co2Sensor.setCo2Ppm(newValue);
    }

    private double getCo2Change() {
        if (co2Dispenser.getState().getState() == Co2DispenserState.ON.getState()) {
            return generateRandomDoubleFromRange(10, 20);
        } else
            return 0;
    }

    public void setCo2DispenserSwitch(Co2DispenserDTO dto) {
        if (Objects.nonNull(dto.getCo2DispenserState()))
            co2Dispenser.setState(dto.getCo2DispenserState());
    }

    @Override
    public Double getSimulatedValue() {
        return co2Sensor.getCo2Ppm();
    }
}
