package com.example.simulator;

import com.example.simulator.greenhouse.simulators.SimulationType;
import com.example.simulator.service.GreenhouseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimulatorApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(GreenhouseService greenhouseService) {

		return (args) -> {
			greenhouseService.addSimulation(1, SimulationType.HUMIDITY);
			greenhouseService.addSimulation(1, SimulationType.PAR);
			greenhouseService.addSimulation(1, SimulationType.WATER);
			greenhouseService.addSimulation(1, SimulationType.TEMPERATURE);
			greenhouseService.addSimulation(1, SimulationType.SALINITY);
			greenhouseService.addSimulation(1, SimulationType.TEMPERATURE_SOIL);
			greenhouseService.addSimulation(1, SimulationType.CO2);
		};
	}

}
