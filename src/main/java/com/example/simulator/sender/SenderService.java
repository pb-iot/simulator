package com.example.simulator.sender;

import com.example.simulator.greenhouse.Greenhouse;
import com.example.simulator.greenhouse.GreenhousesData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class SenderService {

    private final static String url = "https://gm-api.wvffle.net/graphql";

    @Scheduled(cron = "0/10 * * * * *") // co 5 sekund - na czas developmentu
    public void sendAllMeasurementsToTheBackend() {
        RestTemplate restTemplate = new RestTemplate();
        org.springframework.http.HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        GreenhousesData greenHouses = GreenhousesData.getInstance();
        HashMap<Integer, Greenhouse> greenhouseList = greenHouses.getGreenhouseList();
        HttpEntity<HashMap<Integer, Greenhouse>> entity = new HttpEntity<>(greenhouseList,headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        System.out.println(response.getStatusCode());

    }
}
