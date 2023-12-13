package com.example.simulator.controller;

import com.example.simulator.configurations.response.ResponseData;
import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/greenhouses")
public class GreenhouseDataController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "GREENHOUSE_DOES_NOT_EXIST")
    })
    @Operation(summary = "It is used to get all measurements")
    @GetMapping(path = "/getAllMeasurements", produces = "application/json")
    public ResponseEntity<ResponseData> getAllMeasurements(){
        GreenhousesData greenHouses = GreenhousesData.getInstance();
        HashMap<Integer, Greenhouse> greenhouseList = greenHouses.getGreenhouseList();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(greenhouseList));
    }
}
