package com.example.simulator.greenhouse.devices.light;

public enum LightState {
    ON(1),
    OFF(-1);

    private final double STATE;

    LightState(double STATE){
        this.STATE = STATE;
    }

    public double getState(){
        return STATE;
    }
}
