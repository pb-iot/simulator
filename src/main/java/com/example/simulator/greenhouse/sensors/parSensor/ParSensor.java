package com.example.simulator.greenhouse.sensors.parSensor;

import com.example.simulator.utils.forecast.WeatherForecast;
import com.example.simulator.utils.forecast.data.CurrentWeather;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParSensor {
    
    private double parValue;

    public ParSensor() {
        updateParValue();
    }

    public void updateParValue() {
        WeatherForecast weatherForecast = new WeatherForecast();
        CurrentWeather currentWeather = weatherForecast.getParData();

        double parShortwave = currentWeather.getShortwaveRadiation();

        // direct_radiation - Preceding 15 minutes mean - W/m²
        double parDirect = currentWeather.getDirectRadiation();

        // diffuse_radiation - Preceding 15 minutes mean - W/m²
        double parDiffuse = currentWeather.getDiffuseRadiation();

        parValue = parShortwave + parDirect + parDiffuse;
    }
}

/*  Ogólne wytyczne dotyczące poziomów PAR dla roślin:

    Niski poziom PAR: 50-200 µmol/m²/s - może być wystarczający do podtrzymania
    życia roślin, ale nie jest optymalny dla intensywnego wzrostu.

    Średni poziom PAR: 200-400 µmol/m²/s - jest to zakres, który zazwyczaj jest
    uznawany za odpowiedni do wzrostu większości roślin.

    Wysoki poziom PAR: 400-1000 µmol/m²/s - jest to zakres, który jest zazwyczaj stosowany
    w intensywnych uprawach komercyjnych lub do badań naukowych nad fotosyntezą.*/
