package com.example.simulator.controller;

import com.example.simulator.DTOs.*;
import com.example.simulator.configurations.response.ResponseData;
import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import com.example.simulator.greenhouse.devices.water.Water;
import com.example.simulator.greenhouse.simulators.SimulationType;
import com.example.simulator.service.GreenhouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/greenhouses/{greenhouseId}")
public class GreenhouseController {

    @Autowired
    private GreenhouseService greenhouseService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400", description = "SIMULATION_ALREADY_ADDED"),
            @ApiResponse(responseCode = "404", description = "GREENHOUSE_DOES_NOT_EXIST")
    })
    @Operation(summary = "Add the given simulation type at the specified greenhouse")
    @PostMapping(path = "/addSimulation", produces = "application/json")
    public ResponseEntity<ResponseData> addSimulation(@PathVariable Integer greenhouseId, @RequestParam SimulationType type) {
        greenhouseService.addSimulation(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "SIMULATION_OF_GIVEN_TYPE_DOES_NOT_EXIST"),
            @ApiResponse(responseCode = "404", description = "GREENHOUSE_DOES_NOT_EXIST")

    })
    @Operation(summary = "Delete the given simulation type at the specified greenhouse")
    @DeleteMapping(path = "/deleteSimulation", produces = "application/json")
    public ResponseEntity<ResponseData> deleteSimulation(@PathVariable Integer greenhouseId, @RequestParam SimulationType type) {
        greenhouseService.deleteSimulation(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "SIMULATION_OF_GIVEN_TYPE_DOES_NOT_EXIST"),
            @ApiResponse(responseCode = "404", description = "GREENHOUSE_DOES_NOT_EXIST")
    })
    @Operation(summary = "Gives the current value of the given simulation")
    @GetMapping(path = "/getSimulationValue", produces = "application/json")
    public ResponseEntity<ResponseData<SensorValueDTO>> getSimulationValue(@PathVariable Integer greenhouseId, @RequestParam SimulationType type) {
        SensorValueDTO data = greenhouseService.getSimulationValue(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(data));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "SIMULATION_OF_GIVEN_TYPE_DOES_NOT_EXIST"),
            @ApiResponse(responseCode = "404", description = "GREENHOUSE_DOES_NOT_EXIST")
    })
    @Operation(summary = "It is used to manage the temperature in the greenhouse")
    @PutMapping(path = "/setAirConditioningValue", produces = "application/json")
    public ResponseEntity<ResponseData> setAirConditioningValue(@PathVariable Integer greenhouseId, @Validated @RequestBody AirConditioningDTO airConditioningDTO) {
        greenhouseService.setAirConditioningValue(greenhouseId, airConditioningDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "SIMULATION_OF_GIVEN_TYPE_DOES_NOT_EXIST"),
            @ApiResponse(responseCode = "404", description = "GREENHOUSE_DOES_NOT_EXIST")
    })
    @Operation(summary = "It is used to manage the humidity in the greenhouse")
    @PutMapping(path = "/setHumidityValue", produces = "application/json")
    public ResponseEntity<ResponseData> setHumidityValue(@PathVariable Integer greenhouseId, @Validated @RequestBody UpdateHumidifierDTO dto) {
        greenhouseService.setHumidityValue(greenhouseId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "SIMULATION_OF_GIVEN_TYPE_DOES_NOT_EXIST"),
            @ApiResponse(responseCode = "404", description = "GREENHOUSE_DOES_NOT_EXIST")
    })
    @Operation(summary = "It is used to manage the humidity in the greenhouse")
    @PutMapping(path = "/setWaterLevel", produces = "application/json")
    public ResponseEntity<ResponseData> setWaterLevel(@PathVariable Integer greenhouseId, @Validated @RequestBody WaterDTO dto) {
        greenhouseService.setWaterLevel(greenhouseId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "SIMULATION_OF_GIVEN_TYPE_DOES_NOT_EXIST"),
            @ApiResponse(responseCode = "404", description = "GREENHOUSE_DOES_NOT_EXIST")
    })
    @Operation(summary = "It is used to manage the amount of light in the greenhouse")
    @PutMapping(path = "/setLight", produces = "application/json")
    public ResponseEntity<ResponseData> setLight(@PathVariable Integer greenhouseId, @Validated @RequestBody LightDTO dto) {
        greenhouseService.setLight(greenhouseId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "SIMULATION_OF_GIVEN_TYPE_DOES_NOT_EXIST"),
            @ApiResponse(responseCode = "404", description = "GREENHOUSE_DOES_NOT_EXIST")
    })
    @Operation(summary = "It is used to manage the salinity of soil")
    @PutMapping(path = "/setSalinityValue", produces = "application/json")
    public ResponseEntity<ResponseData> setSalinityValue(@PathVariable Integer greenhouseId, @Validated @RequestBody UpdateSalinityDeviceDTO dto) {
        greenhouseService.setSalinityValue(greenhouseId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }
}

