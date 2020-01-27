package com.example.flobizassignment.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.flobizassignment.R;
import com.example.flobizassignment.adapter.CitiesAdapter;
import com.example.flobizassignment.model.city.CityApi;
import com.example.flobizassignment.model.city.City;
import com.example.flobizassignment.model.city.CityJSONResponse;
import com.example.flobizassignment.viewmodels.CityViewModel;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<City> data;
    private CitiesAdapter adapter;
    private ArrayList<City> cityArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);


        CityViewModel model = ViewModelProviders.of(this).get(CityViewModel.class);
        model.getCities().observe(this, new Observer<ArrayList<City>>() {
            @Override
            public void onChanged(ArrayList<City> city) {
                //adapter = new CitiesAdapter(recyclerView,city);

            }
        });


        Retrofit retrofit = new Retrofit.Builder().baseUrl(CityApi.CITY_URL).addConverterFactory(GsonConverterFactory.create()).build();

        CityApi cityApi = retrofit.create(CityApi.class);
        Call<CityJSONResponse> call = cityApi.getJSON();

        call.enqueue(new Callback<CityJSONResponse>() {
            @Override
            public void onResponse(Call<CityJSONResponse> call, Response<CityJSONResponse> response) {
                CityJSONResponse jsonResponse = response.body();
                cityArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getCities()));
                System.out.println("cityArrayList: "+cityArrayList);
                recyclerView.setAdapter(new CitiesAdapter(recyclerView,cityArrayList));
            }

            @Override
            public void onFailure(Call<CityJSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
