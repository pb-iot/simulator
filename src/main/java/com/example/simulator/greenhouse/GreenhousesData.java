package com.example.simulator.greenhouse;

import java.util.HashMap;


public class GreenhousesData {

    private static GreenhousesData instance;
    private final HashMap<Integer, Greenhouse> greenhouseList;

    private GreenhousesData() {
        greenhouseList = new HashMap<>();
        greenhouseList.put(0, new Greenhouse());
    }

    public static GreenhousesData getInstance()
    {
        if (instance == null)
        {
            instance = new GreenhousesData();
        }
        return instance;
    }

    public HashMap<Integer, Greenhouse> getGreenhouseList() {
        return greenhouseList;
    }
}
