package com.example.simulator.data;

import lombok.Data;

@Data
public class SetTargetRequestBody {
    private Integer greenhouseId;
    private String sensorName;
    private Double target;
}
