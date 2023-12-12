package com.example.simulator.greenhouse;

import com.example.simulator.configurations.response.ResponseMessage;
import com.example.simulator.exceptions.basic.BasicNotFoundException;

import java.util.HashMap;
import java.util.Objects;


public class GreenhousesData {

    private static GreenhousesData instance;
    private final HashMap<Integer, Greenhouse> greenhouseList;

    private GreenhousesData() {
        greenhouseList = new HashMap<>();
        greenhouseList.put(0, new Greenhouse());
    }

    public static GreenhousesData getInstance() {
        if (instance == null) {
            instance = new GreenhousesData();
        }
        return instance;
    }

    public Greenhouse getGreenhouse(Integer id) {
        Greenhouse greenhouse = greenhouseList.get(id);

        if (Objects.nonNull(greenhouse))
            return greenhouse;

        throw new BasicNotFoundException(ResponseMessage.GREENHOUSE_DOES_NOT_EXIST);
    }

    public HashMap<Integer, Greenhouse> getGreenhouseList() {
        return greenhouseList;
    }
}
