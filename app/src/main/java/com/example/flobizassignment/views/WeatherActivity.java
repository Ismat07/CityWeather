package com.example.flobizassignment.views;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flobizassignment.R;

public class WeatherActivity extends AppCompatActivity {

    TextView tv_temp,tv_pres,tv_humid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        tv_temp = findViewById(R.id.tv_temp);
        tv_pres = findViewById(R.id.tv_pres);
        tv_humid = findViewById(R.id.tv_humid);

        setTitle(getIntent().getStringExtra("cityname"));

    }
}

