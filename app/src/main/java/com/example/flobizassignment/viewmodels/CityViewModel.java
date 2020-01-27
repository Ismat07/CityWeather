package com.example.flobizassignment.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flobizassignment.adapter.CitiesAdapter;
import com.example.flobizassignment.model.city.City;
import com.example.flobizassignment.model.city.CityApi;
import com.example.flobizassignment.model.city.CityJSONResponse;
import com.example.flobizassignment.views.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CityViewModel extends ViewModel {

    private RecyclerView recyclerView;
    private ArrayList<City> cityArrayList;
    private MutableLiveData<City> city;
    private MutableLiveData<ArrayList<City>> arrayListMutableLiveData;
    //private ArrayList<City> data;
    MainActivity context;

    public LiveData<ArrayList<City>> getCities() {
        if (arrayListMutableLiveData == null) {
            arrayListMutableLiveData = new MutableLiveData<ArrayList<City>>();
            loadCities();
        }
        return arrayListMutableLiveData;
    }

//    public LiveData<City> getCities() {
//        if (city == null) {
//            city = new MutableLiveData<City>();
//            loadCities();
//        }
//        return city;
//    }

    private void loadCities() {
    }
}
