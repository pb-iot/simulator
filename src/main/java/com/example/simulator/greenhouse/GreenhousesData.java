package com.example.simulator.greenhouse;

import java.util.ArrayList;
import java.util.List;


public class GreenhousesData {

    private static GreenhousesData instance;
    private List<Greenhouse> greenhouseList;

    private GreenhousesData()
    {
        greenhouseList = new ArrayList<>();
        greenhouseList.add(new Greenhouse());
    }

    public static GreenhousesData getInstance()
    {
        if (instance == null)
        {
            instance = new GreenhousesData();
        }
        return instance;
    }

    public List<Greenhouse> getGreenhouseList()
    {
        return greenhouseList;
    }
}
