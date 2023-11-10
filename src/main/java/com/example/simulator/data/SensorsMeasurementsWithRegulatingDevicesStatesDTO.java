package com.example.simulator.data;

import com.example.simulator.DTOs.AirTemperatureDTO;
import lombok.*;

import java.time.LocalDateTime;


/**
 * Klasa trzymająca wartości wszystkich odczytów symulacji (np. sensor temperatury)
 * wraz ze stanami urządzeń zmieniających te wartości (np. klimatyzacja).
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorsMeasurementsWithRegulatingDevicesStatesDTO {
    private LocalDateTime timestamp;
    private AirTemperatureDTO airTemperature;


    /*
    private Double humidity;
    private Double parLevel;
    private Double co2;
    private Double substrateWaterLevel;
    private Double salinityLevel;
    private Double substrateTemperature;
    private Double substrateWeight;
    private Double plantWeight;
    private Double stemVariability;

    */

}
