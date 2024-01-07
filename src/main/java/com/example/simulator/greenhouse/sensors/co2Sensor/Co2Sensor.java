package com.example.simulator.greenhouse.sensors.co2Sensor;

import static com.example.simulator.utils.random.RandomGenerator.generateRandomDoubleFromRange;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Co2Sensor {

    private double co2Ppm = 900; // zawartość CO2 w powietrzu, wyrażona w ppm — wartość ta powinna się wahać w przedziale 600 do 1200 ppm (0.6% do 1.2%)

    public Co2Sensor() {
        updateCo2Value();
    }

    public void updateCo2Value() {
        co2Ppm = generateRandomDoubleFromRange(co2Ppm - 3, co2Ppm + 3);//stara wartość +- 3
    }
}
