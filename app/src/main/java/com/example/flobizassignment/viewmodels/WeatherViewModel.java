package com.example.flobizassignment.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flobizassignment.model.weather.Weather;
import com.example.flobizassignment.model.weather.WeatherApi;
import com.example.flobizassignment.model.weather.WeatherJSONResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<Weather> weather;
    private ArrayList<Weather> weatherArrayList;

    public LiveData<Weather> getWeather() {
        if (weather == null) {
            weather = new MutableLiveData<Weather>();
            loadWeather();
        }
        return weather;
    }

    private void loadWeather() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WeatherApi.Weather_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WeatherApi api = retrofit.create(WeatherApi.class);
        Call<List<WeatherJSONResponse>> call = api.getWeatherJSON();

        call.enqueue(new Callback<List<WeatherJSONResponse>>() {
            @Override
            public void onResponse(Call<List<WeatherJSONResponse>> call, Response<List<WeatherJSONResponse>> response) {
                List<WeatherJSONResponse> weatherJSONResponse = response.body();
                //weatherArrayList = new ArrayList<>(Arrays.asList(weatherJSONResponse.get(0).getWeather()));
                System.out.println("weatherArrayList ="+weatherArrayList);
            }

            @Override
            public void onFailure(Call<List<WeatherJSONResponse>> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}

