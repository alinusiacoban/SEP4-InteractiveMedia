package com.aliniacoban.fishingindenmark.terraiot.API;

import com.google.gson.annotations.SerializedName;

public class Level {

    private int id;

    private String co2;

    private String humidity;

    private String temperature;

    public Level(int id, String co2, String humidity, String temperature) {
        this.id = id;
        this.co2 = co2;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public Level(String co2, String humidity, String temperature) {
        this.co2 = co2;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public String getCo2() {
        return co2;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemperature() {
        return temperature;
    }
}