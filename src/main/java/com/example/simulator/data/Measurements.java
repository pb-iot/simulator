package com.example.simulator.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Measurements {
    private LocalDateTime timestamp;
    private Double temperature;
    //private Double humidity;
    //private Double co2;
    //private Double waterTemperature;
    //private Double substrateTemperature;
    //private Double salinityLevel;
    //private Double plantWeight;
    //private Double substrateWeight;

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
