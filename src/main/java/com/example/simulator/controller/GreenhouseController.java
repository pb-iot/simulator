package com.example.simulator.controller;

import com.example.simulator.DTOs.AirConditioningDTO;
import com.example.simulator.DTOs.SensorValueDTO;
import com.example.simulator.configurations.response.ResponseData;
import com.example.simulator.greenhouse.simulators.SimulationType;
import com.example.simulator.service.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/greenhouses/{greenhouseId}")
public class GreenhouseController {

    @Autowired
    private GreenhouseService greenhouseService;

    @PostMapping(path = "/addSimulation", produces = "application/json")
    public ResponseEntity<?> addSimulation(@PathVariable Integer greenhouseId, @RequestParam SimulationType type) {
        greenhouseService.addSimulation(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseData<>());
    }

    @DeleteMapping(path = "/deleteSimulation", produces = "application/json")
    public ResponseEntity<?> deleteSimulation(@PathVariable Integer greenhouseId, @RequestParam SimulationType type) {
        greenhouseService.deleteSimulation(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @GetMapping(path = "/getSimulationValue", produces = "application/json")
    public ResponseEntity<?> getSimulationValue(@PathVariable Integer greenhouseId, @RequestParam SimulationType type) {
        SensorValueDTO data = greenhouseService.getSimulationValue(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(data));
    }

    @PutMapping(path = "/setAirConditioningValue", produces = "application/json")
    public ResponseEntity<?> setAirConditioningValue(@PathVariable Integer greenhouseId, @Validated @RequestBody AirConditioningDTO airConditioningDTO) {
        greenhouseService.setAirConditioningValue(greenhouseId, airConditioningDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    // TODO: 24/10/2023 dodać zbiorczy endpoint dla odczytów wszystkich szklarni na raz
}

