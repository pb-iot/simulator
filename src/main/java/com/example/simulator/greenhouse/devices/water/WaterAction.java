package com.example.simulator.greenhouse.devices.water;

public enum WaterAction {
    OFF(-1),
    ON(1);

    private final double ACTION;

    WaterAction(double action) {
        this.ACTION = action;
    }

    public double getAction() {
        return ACTION;
    }
}
