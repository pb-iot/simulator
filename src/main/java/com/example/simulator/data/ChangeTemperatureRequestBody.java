package com.example.simulator.data;

import lombok.Data;

@Data
public class ChangeTemperatureRequestBody {
    private Integer greenhouseId;
    private Double value;
}
