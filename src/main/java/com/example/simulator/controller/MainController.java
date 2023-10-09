package com.example.simulator.controller;

import com.example.simulator.simulation.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class MainController {

    @Autowired
    private SimulatorService simulatorService;

    @GetMapping(path = "/current-measurements"/*, produces = "application/json"*/)
    public String getCurrentMeasurements() {
        return simulatorService.getCurrentMeasurements(0).toString();   // tu zamiast toString trzeba będzie potem zrobić żeby samo się serializowało
    }
}
