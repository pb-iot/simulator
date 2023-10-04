package com.example.simulator.data;

import lombok.Builder;

@Builder
public class Measurements {
    private double temperature;
    //private double humidity;
    //...

    @Override
    public String toString() {
        return "{\n" +
                "\t" + "temperature=" + temperature + "\n" +
                //"\t" + "humidity=" + humidity + "\n" +
                //...
                '}';
    }
}
