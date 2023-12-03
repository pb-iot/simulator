package com.example.simulator.greenhouse.sensors.parSensor;

import com.example.simulator.utils.forecast.WeatherForecast;

public class ParSensor {

    private double value;

    public ParSensor() {
        WeatherForecast weatherForecast = new WeatherForecast();

    }

    public double calculatePAR(double shortwaveRadiation, double directRadiation, double diffuseRadiation) {

        // shortwave_radiation - Preceding 15 minutes mean - W/m²
        double parShortwave = shortwaveRadiation;

        // direct_radiation - Preceding 15 minutes mean - W/m²
        double parDirect = (directRadiation >= 400 && directRadiation <= 700) ? directRadiation : 0;

        // diffuse_radiation - Preceding 15 minutes mean - W/m²
        double parDiffuse = (diffuseRadiation >= 400 && diffuseRadiation <= 700) ? diffuseRadiation : 0;

        // Współczynnik PAR to suma radiacji w zakresie fotosyntetycznym.
        double par = parShortwave + parDirect + parDiffuse;

        return par;
    }
}

/*  Ogólne wytyczne dotyczące poziomów PAR dla roślin:

    Niski poziom PAR: 50-200 µmol/m²/s - może być wystarczający do podtrzymania
    życia roślin, ale nie jest optymalny dla intensywnego wzrostu.

    Średni poziom PAR: 200-400 µmol/m²/s - jest to zakres, który zazwyczaj jest
    uznawany za odpowiedni do wzrostu większości roślin.

    Wysoki poziom PAR: 400-1000 µmol/m²/s - jest to zakres, który jest zazwyczaj stosowany
    w intensywnych uprawach komercyjnych lub do badań naukowych nad fotosyntezą.*/
