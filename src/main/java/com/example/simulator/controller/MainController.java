package com.example.simulator.controller;

import com.example.simulator.data.Measurements;
import com.example.simulator.simulation.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class MainController {

    @Autowired
    private SimulatorService simulatorService;

    @GetMapping(path = "/current-measurements", produces = "application/json")
    public ResponseEntity<Measurements> getCurrentMeasurements() {
        return ResponseEntity.status(HttpStatus.OK).body(simulatorService.getCurrentMeasurements(0));
    }
}
