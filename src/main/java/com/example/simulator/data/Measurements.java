package com.example.simulator.data;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Measurements {
    private LocalDateTime timestamp;
    private double temperature;
    //private double humidity;
    //...

    @Override
    public String toString() {
        return "{\n" +
                "\t" + "timestamp=" + timestamp + "\n" +
                "\t" + "temperature=" + temperature + "\n" +
                //"\t" + "humidity=" + humidity + "\n" +
                //...
                '}';
    }
}
