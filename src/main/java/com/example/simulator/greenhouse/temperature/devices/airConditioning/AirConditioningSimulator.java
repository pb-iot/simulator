package com.example.simulator.greenhouse.temperature.devices.airConditioning;

import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AirConditioningSimulator {

    private final double RANGE_MIN_TEMP = 0.05;
    private final double RANGE_MAX_TEMP = 0.20;

    @Scheduled(fixedRate = 2 * 60000) // for 2 minutes
    public void scheduledTask() {
        List<Greenhouse> greenhouseList = GreenhousesData.getInstance().getGreenhouseList();

        greenhouseList.forEach(greenhouse ->
                greenhouse.getTemperature().ACSimulator(RANGE_MIN_TEMP, RANGE_MAX_TEMP)
        );
    }


}
