package com.example.simulator.greenhouse.devices.co2_dispenser;

public enum Co2DispenserState {
    ON(1),
    OFF(-1);

    private final double STATE;

    Co2DispenserState(double STATE) {
        this.STATE = STATE;
    }

    public double getState() {
        return STATE;
    }
}
