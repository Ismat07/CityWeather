package com.example.flobizassignment.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.flobizassignment.model.city.City;
import com.example.flobizassignment.model.city.CityClient;
import com.example.flobizassignment.model.city.CityJSONResponse;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityViewModel extends ViewModel {

    private ArrayList<City> cityArrayList;
    private MutableLiveData<ArrayList<City>> arrayListMutableLiveData;

    public LiveData<ArrayList<City>> getCities() {
        if (arrayListMutableLiveData == null) {
            arrayListMutableLiveData = new MutableLiveData<>();
            loadCities();
        }
        return arrayListMutableLiveData;
    }

    public void loadCities() {
        CityClient.getINSTANCE().getJSON().enqueue(new Callback<CityJSONResponse>() {
            @Override
            public void onResponse(Call<CityJSONResponse> call, Response<CityJSONResponse> response) {
                CityJSONResponse jsonResponse = response.body();
                cityArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getCities()));
                arrayListMutableLiveData.setValue(cityArrayList);
            }

            @Override
            public void onFailure(Call<CityJSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
