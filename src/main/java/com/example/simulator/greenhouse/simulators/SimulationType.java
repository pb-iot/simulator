package com.example.simulator.greenhouse.simulators;

import java.util.function.Supplier;

public enum SimulationType {
    TEMPERATURE(TemperatureSimulation::new);

    private final Supplier<Simulable> simulationSupplier;

    SimulationType(Supplier<Simulable> simulationSupplier) {
        this.simulationSupplier = simulationSupplier;
    }


    public Simulable install() {
        return simulationSupplier.get();
    }
}
