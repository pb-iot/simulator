package com.example.simulator.greenhouse.simulators;

import java.util.function.Supplier;

public enum SimulationType {
    TEMPERATURE(TemperatureSimulation::new),
    HUMIDITY(HumiditySimulation::new),
    WATER(WaterSimulation::new),
    SALINITY(SalinitySimulation::new),
    CO2(Co2Simulation::new),
    TEMPERATURE_SOIL(TemperatureSoilSimulation::new),
    PAR(ParSimulation::new);

    private final Supplier<Simulable> simulationSupplier;

    SimulationType(Supplier<Simulable> simulationSupplier) {
        this.simulationSupplier = simulationSupplier;
    }

    public Simulable getSimulable() {
        return simulationSupplier.get();
    }
}
