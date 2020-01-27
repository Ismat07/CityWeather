package com.example.flobizassignment.model.weather;

public class Weather {
    private String temp;
    private String pressure;
    private String humidity;

    public Weather(String temp, String pressure, String humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getTemp() {
        return temp;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }


}
