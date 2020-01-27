package com.example.flobizassignment.model.weather;

import java.util.List;

public class WeatherList {
    List<Weather> weatherList;

    public WeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }
}
