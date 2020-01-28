package com.example.flobizassignment.views;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flobizassignment.R;
import com.example.flobizassignment.model.weather.Weather;
import com.example.flobizassignment.viewmodels.WeatherViewModel;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {

    TextView tv_temp,tv_pres,tv_humid;
    WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        tv_temp = findViewById(R.id.tv_temp);
        tv_pres = findViewById(R.id.tv_pres);
        tv_humid = findViewById(R.id.tv_humid);

        setTitle(getIntent().getStringExtra("cityname"));
        initViews();
        //tv_temp.setText();
    }

    public void initViews() {
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);

        weatherViewModel.loadWeather();
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        //final CitiesAdapter adapter = new CitiesAdapter();
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(adapter);

//        weatherViewModel.getWeather().observe(this, new Observer<ArrayList<Weather>>() {
//            @Override
//            public void onChanged(ArrayList<Weather> city) {
//                adapter.setList(city);
//            }
//        });
    }
}

