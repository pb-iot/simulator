package com.example.simulator.greenhouse.devices.salinity;

public enum SalinityDeviceState {
    ON(1),
    OFF(-1);

    private final double STATE;

    SalinityDeviceState(double STATE){
        this.STATE = STATE;
    }

    public double getState(){
        return STATE;
    }
}
