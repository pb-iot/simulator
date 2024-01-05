package com.example.simulator.controller;

import com.example.simulator.DTOs.*;
import com.example.simulator.configurations.response.ResponseData;
import com.example.simulator.configurations.swagger.SwaggerDescription;
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


@RestController
@RequestMapping("/api/v1/greenhouses/{greenhouseId}")
public class GreenhouseController {

    @Autowired
    private GreenhouseService greenhouseService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400", description = SwaggerDescription.SIMULATION_DOES_NOT_EXIST),
            @ApiResponse(responseCode = "404", description = SwaggerDescription.GREENHOUSE_DOES_NOT_EXIST)
    })
    @Operation(summary = SwaggerDescription.ADD_SIMULATION_DESCRIPTION)
    @PostMapping(path = "/addSimulation", produces = "application/json")
    public ResponseEntity<ResponseData> addSimulation(@PathVariable Integer greenhouseId,
                                                      @RequestParam SimulationType type) {
        greenhouseService.addSimulation(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = SwaggerDescription.SIMULATION_DOES_NOT_EXIST),
            @ApiResponse(responseCode = "404", description = SwaggerDescription.GREENHOUSE_DOES_NOT_EXIST)
    })
    @Operation(summary = SwaggerDescription.DELETE_SIMULATION_DESCRIPTION)
    @DeleteMapping(path = "/deleteSimulation", produces = "application/json")
    public ResponseEntity<ResponseData> deleteSimulation(@PathVariable Integer greenhouseId,
                                                         @RequestParam SimulationType type) {
        greenhouseService.deleteSimulation(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = SwaggerDescription.SIMULATION_DOES_NOT_EXIST),
            @ApiResponse(responseCode = "404", description = SwaggerDescription.GREENHOUSE_DOES_NOT_EXIST)
    })
    @Operation(summary = SwaggerDescription.GET_SIMULATION_VALUE_DESCRIPTION)
    @GetMapping(path = "/getSimulationValue", produces = "application/json")
    public ResponseEntity<ResponseData<SensorValueDTO>> getSimulationValue(@PathVariable Integer greenhouseId,
                                                                           @RequestParam SimulationType type) {
        SensorValueDTO data = greenhouseService.getSimulationValue(greenhouseId, type);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(data));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = SwaggerDescription.SIMULATION_DOES_NOT_EXIST),
            @ApiResponse(responseCode = "404", description = SwaggerDescription.GREENHOUSE_DOES_NOT_EXIST)
    })
    @Operation(summary = SwaggerDescription.SET_AIR_CONDITIONING_DESCRIPTION)
    @PutMapping(path = "/setAirConditioningValue", produces = "application/json")
    public ResponseEntity<ResponseData> setAirConditioningValue(@PathVariable Integer greenhouseId,
                                                                @Validated @RequestBody AirConditioningDTO airConditioningDTO) {
        greenhouseService.setAirConditioningValue(greenhouseId, airConditioningDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = SwaggerDescription.SIMULATION_DOES_NOT_EXIST),
            @ApiResponse(responseCode = "404", description = SwaggerDescription.GREENHOUSE_DOES_NOT_EXIST)
    })
    @Operation(summary = SwaggerDescription.SET_HUMIDITY_DESCRIPTION)
    @PutMapping(path = "/setHumidityValue", produces = "application/json")
    public ResponseEntity<ResponseData> setHumidityValue(@PathVariable Integer greenhouseId,
                                                         @Validated @RequestBody UpdateHumidifierDTO dto) {
        greenhouseService.setHumidityValue(greenhouseId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = SwaggerDescription.SIMULATION_DOES_NOT_EXIST),
            @ApiResponse(responseCode = "404", description = SwaggerDescription.GREENHOUSE_DOES_NOT_EXIST)
    })
    @Operation(summary = SwaggerDescription.SET_WATER_LEVEL_DESCRIPTION)
    @PutMapping(path = "/setWaterLevel", produces = "application/json")
    public ResponseEntity<ResponseData> setWaterLevel(@PathVariable Integer greenhouseId,
                                                      @Validated @RequestBody WaterDTO dto) {
        greenhouseService.setWaterLevel(greenhouseId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = SwaggerDescription.SIMULATION_DOES_NOT_EXIST),
            @ApiResponse(responseCode = "404", description = SwaggerDescription.GREENHOUSE_DOES_NOT_EXIST)
    })
    @Operation(summary = SwaggerDescription.SET_LIGHT_DESCRIPTION)
    @PutMapping(path = "/setLight", produces = "application/json")
    public ResponseEntity<ResponseData> setLight(@PathVariable Integer greenhouseId,
                                                 @Validated @RequestBody LightDTO dto) {
        greenhouseService.setLight(greenhouseId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = SwaggerDescription.SIMULATION_DOES_NOT_EXIST),
            @ApiResponse(responseCode = "404", description = SwaggerDescription.GREENHOUSE_DOES_NOT_EXIST)
    })
    @Operation(summary = SwaggerDescription.SET_CO2_DISPENSER_DESCRIPTION)
    @PutMapping(path = "/setCo2Dispenser", produces = "application/json")
    public ResponseEntity<ResponseData> setCo2Dispenser(@PathVariable Integer greenhouseId,
                                                        @Validated @RequestBody Co2DispenserDTO dto) {
        greenhouseService.setCo2Dispenser(greenhouseId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = SwaggerDescription.SIMULATION_DOES_NOT_EXIST),
            @ApiResponse(responseCode = "404", description = SwaggerDescription.GREENHOUSE_DOES_NOT_EXIST)
    })
    @Operation(summary = SwaggerDescription.SET_SALINITY_DESCRIPTION)
    @PutMapping(path = "/setSalinityValue", produces = "application/json")
    public ResponseEntity<ResponseData> setSalinityValue(@PathVariable Integer greenhouseId, @Validated @RequestBody UpdateSalinityDeviceDTO dto) {
        greenhouseService.setSalinityValue(greenhouseId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>());
    }
}
