package com.example.flobizassignment.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.flobizassignment.R;
import com.example.flobizassignment.adapter.CitiesAdapter;
import com.example.flobizassignment.model.city.City;
import com.example.flobizassignment.viewmodels.CityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    public void initViews() {
        model = ViewModelProviders.of(this).get(CityViewModel.class);

        model.loadCities();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final CitiesAdapter adapter = new CitiesAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        model.getCities().observe(this, new Observer<ArrayList<City>>() {
            @Override
            public void onChanged(ArrayList<City> city) {
                adapter.setList(city);
            }
        });
    }
}
