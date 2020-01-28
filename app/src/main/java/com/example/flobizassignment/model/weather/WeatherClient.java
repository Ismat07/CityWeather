package com.example.flobizassignment.model.weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {
    private WeatherApi weatherApi;
    private static WeatherClient INSTANCE;

    private WeatherClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WeatherApi.Weather_URL).addConverterFactory(GsonConverterFactory.create()).build();

        weatherApi = retrofit.create(WeatherApi.class);
    }

    public static WeatherClient getINSTANCE(){
        if (null == INSTANCE){
            INSTANCE = new WeatherClient();
        }
        return INSTANCE;
    }

    public Call<List<WeatherJSONResponse>> getWeatherJSON(){
        return weatherApi.getWeatherJSON();
    }
}
