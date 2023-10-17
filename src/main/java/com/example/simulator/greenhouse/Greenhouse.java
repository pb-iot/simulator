package com.example.simulator.greenhouse;

import com.example.simulator.greenhouse.temperature.Temperature;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Greenhouse {

    private String id = UUID.randomUUID().toString();

    private Temperature temperature = new Temperature();
}
