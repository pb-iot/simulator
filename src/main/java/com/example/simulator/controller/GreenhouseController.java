package com.example.simulator.controller;

import com.example.simulator.DTOs.SensorValueDTO;
import com.example.simulator.configurations.response.ResponseData;
import com.example.simulator.greenhouse.simulators.SimulationType;
import com.example.simulator.service.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/greenhouses/{greenhouseId}")
public class GreenhouseController {

    @Autowired
    private GreenhouseService greenhouseService;

    @PostMapping(path = "/installation", produces = "application/json")
    public ResponseEntity<?> installSimulation(@PathVariable Integer greenhouseId, @RequestParam SimulationType type) {
        greenhouseService.installSimulation(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseData<>());
    }

    @DeleteMapping(path = "/breakup", produces = "application/json")
    public ResponseEntity<?> breakupSimulation(@PathVariable Integer greenhouseId, @RequestParam SimulationType type) {
        greenhouseService.breakupSimulation(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseData<>());
    }

    @GetMapping(path = "/value", produces = "application/json")
    public ResponseEntity<?> getSimulationValue(@PathVariable Integer greenhouseId, @RequestParam SimulationType type) {
        SensorValueDTO data = greenhouseService.getSimulationValue(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(data));
    }


}

