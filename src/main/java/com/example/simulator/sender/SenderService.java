package com.example.simulator.sender;

import com.example.simulator.simulation.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    private SimulatorService simulatorService;

    //@Scheduled(cron = "0 * * * * *") //o każdej pełnej minucie — docelowy cron
    @Scheduled(cron = "0/5 * * * * *") // co 5 sekund - na czas developmentu
    public void sendAllMeasurementsToTheBackend() {
//        Measurements measurements = simulatorService.getCurrentMeasurements(0);
//
//        System.out.println("Measurements:");
//        System.out.println(measurements);
//
//

        // TODO: zamienić na wysyłanie na backend - jak już jakikolwiek backend powstanie
    }
}
