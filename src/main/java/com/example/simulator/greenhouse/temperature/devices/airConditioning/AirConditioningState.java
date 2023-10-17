package com.example.simulator.greenhouse.temperature.devices.airConditioning;

public enum AirConditioningState {
    OFF(0),
    ECO(0.5),
    NORMAL(1),
    TURBO(2);

    private final double GROWN_BONUS;

    AirConditioningState(double grownBonus) {
        this.GROWN_BONUS = grownBonus;
    }

    public double getGrownBonus() {
        return GROWN_BONUS;
    }
}
