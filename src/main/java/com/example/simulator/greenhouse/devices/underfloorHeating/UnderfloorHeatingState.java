package com.example.simulator.greenhouse.devices.underfloorHeating;

public enum UnderfloorHeatingState {
    ON(2),
    OFF(0);

    private final double STATE;

    UnderfloorHeatingState(double STATE) {
        this.STATE = STATE;
    }

    public double getState() {
        return STATE;
    }
}
