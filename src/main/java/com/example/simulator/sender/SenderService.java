package com.example.simulator.sender;

import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import com.example.simulator.greenhouse.simulators.SimulationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

@Service
public class SenderService {

    @Scheduled(cron = "0/10 * * * * *") // co 5 sekund - na czas developmentu
    public void sendAllMeasurementsToTheBackend() throws  IOException {
        GreenhousesData greenHouses = GreenhousesData.getInstance();
        HashMap<Integer, Greenhouse> greenhouseList =
                greenHouses.getGreenhouseList();
        WebClient client = WebClient.builder()
                .baseUrl("https://gm-api.wvffle.net")
                .defaultUriVariables(Collections.singletonMap("url",
                        "https://gm-api.wvffle.net"))
                .build();

        // HttpGraphQlClient graphQlClient =
        //         HttpGraphQlClient.builder(client)
        //                 .build();

        String query = "mutation createEnvironment($greenhouse: Int!, $date: DateTime!, $temperature: Decimal!, $airHumidity: Decimal!, $lightLevel: Decimal!, $par: Decimal!, $co2Level: Decimal!, $soilMoistureLevel: Decimal!, $soilSalinity: Decimal!, $soilTemperature: Decimal!, $weightOfSoilAndPlants: Decimal!, $stemMicroVariability: Decimal!){\n" +
                "    createEnvironment(input: {greenhouse: $greenhouse, date: $date, temperature: $temperature, airHumidity: $airHumidity, lightLevel: $lightLevel, par: $par, co2Level: $co2Level, soilMoistureLevel: $soilMoistureLevel, soilSalinity: $soilSalinity, soilTemperature: $soilTemperature, weightOfSoilAndPlants: $weightOfSoilAndPlants, stemMicroVariability: $stemMicroVariability\n" +
                "    }){\n" +
                "        environment{\n" +
                "            date,\n" +
                "            temperature,\n" +
                "            airHumidity,\n" +
                "            lightLevel,\n" +
                "            par,\n" +
                "            co2Level,\n" +
                "            soilMoistureLevel,\n" +
                "            soilSalinity,\n" +
                "            soilTemperature,\n" +
                "            weightOfSoilAndPlants,\n" +
                "            stemMicroVariability\n" +
                "        }\n" +
                "    }\n" +
                "}";

        DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        Variables variables = new Variables();
        LocalDateTime ldt = LocalDateTime.now();

        greenhouseList.forEach(((integer, greenhouse) -> {
            variables.setGreenhouse(integer);
            variables.setDate(ldt.format(CUSTOM_FORMATTER));
            variables.setTemperature(greenhouse.getSimulation(SimulationType.TEMPERATURE).getSimulatedValue());
            variables.setAirHumidity(greenhouse.getSimulation(SimulationType.HUMIDITY).getSimulatedValue());
            variables.setLightLevel(greenhouse.getSimulation(SimulationType.WATER).getSimulatedValue());
            variables.setPar(greenhouse.getSimulation(SimulationType.PAR).getSimulatedValue());
            variables.setCo2Level(greenhouse.getSimulation(SimulationType.CO2).getSimulatedValue());
            variables.setSoilMoistureLevel(0d);
            variables.setSoilSalinity(greenhouse.getSimulation(SimulationType.SALINITY).getSimulatedValue());
            variables.setSoilTemperature(greenhouse.getSimulation(SimulationType.TEMPERATURE_SOIL).getSimulatedValue());
            variables.setWeightOfSoilAndPlants(0d);
            variables.setStemMicroVariability(0d);
        }));

        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(variables);

        GraphqlRequestBody graphQLRequestBody = new GraphqlRequestBody();
        graphQLRequestBody.setQuery(query);
        graphQLRequestBody.setVariables(s);

        ResponseEntity<String> response = Objects.requireNonNull(client.post()
                .uri("/graphql/")
                .header("Content-Type", "application/json")
                .bodyValue(graphQLRequestBody)
                .exchange().block()).toEntity(String.class).block();

        System.out.println(response);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    static class Variables{
        public Integer greenhouse;
        private String date;
        private Double temperature;
        public Double airHumidity;
        public Double lightLevel;
        public Double par;
        public Double co2Level;
        public Double soilMoistureLevel;
        public Double soilSalinity;
        public Double soilTemperature;
        public Double weightOfSoilAndPlants;
        public Double stemMicroVariability;
    }
}
