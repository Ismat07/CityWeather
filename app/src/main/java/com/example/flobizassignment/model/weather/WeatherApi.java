package com.example.flobizassignment.model.weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {

    String Weather_URL = "https://samples.openweathermap.org/";

    @GET("data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22/")
    Call<List<WeatherJSONResponse>> getWeatherJSON();
}
