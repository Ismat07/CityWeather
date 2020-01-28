package com.example.flobizassignment.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flobizassignment.model.weather.WeatherClient;
import com.example.flobizassignment.model.weather.WeatherJSONResponse;
import com.example.flobizassignment.model.weather.WeatherList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<ArrayList<WeatherList>> arrayListMutableLiveData;
    private ArrayList<WeatherList> weatherArrayList;

    public LiveData<ArrayList<WeatherList>> getWeather() {
        if (arrayListMutableLiveData == null) {
            arrayListMutableLiveData = new MutableLiveData<>();
            loadWeather();
        }
        return arrayListMutableLiveData;
    }

    public void loadWeather() {
        WeatherClient.getINSTANCE().getWeatherJSON().enqueue(new Callback<List<WeatherJSONResponse>>() {
            @Override
            public void onResponse(Call<List<WeatherJSONResponse>> call, Response<List<WeatherJSONResponse>> response) {
                List<WeatherJSONResponse> weatherJSONResponse = response.body();

                weatherArrayList = new ArrayList<>(Arrays.asList(weatherJSONResponse.get(3).getWeather()));
                System.out.println("weatherArrayList ="+weatherArrayList);
                arrayListMutableLiveData.setValue(weatherArrayList);
            }

            @Override
            public void onFailure(Call<List<WeatherJSONResponse>> call, Throwable t) {
                Log.d("Error....",t.getMessage());
            }
        });
    }
}

