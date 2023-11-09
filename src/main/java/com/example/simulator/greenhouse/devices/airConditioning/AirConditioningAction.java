package com.example.simulator.greenhouse.devices.airConditioning;

public enum AirConditioningAction {
    FREEZE(-1),
    HEAT(1);

    private final double ACTION;

    AirConditioningAction(double action) {
        this.ACTION = action;
    }

    public double getAction() {
        return ACTION;
    }
}
