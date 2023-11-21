package com.example.simulator.greenhouse.devices.humidifier;

public enum HumidifierPowerLevel {
    OFF(0),
    ECO(0.5),
    NORMAL(1),
    TURBO(2);

    private final double GROWN_BONUS;

    HumidifierPowerLevel(double grownBonus) {
        this.GROWN_BONUS = grownBonus;
    }

    public double getGrownBonus() {
        return GROWN_BONUS;
    }
}
