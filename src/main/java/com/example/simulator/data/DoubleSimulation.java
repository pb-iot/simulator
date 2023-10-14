package com.example.simulator.data;

import lombok.Getter;
import lombok.Setter;

public interface DoubleSimulation {
    void triggerSimulation();

    Double getSimulatedValue();

    Double getTargetValue();

    void setTargetValue(Double target);
}
