package com.example.flobizassignment.model.city;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CityApi {

    String CITY_URL = "https://api.myjson.com/bins/";

    @GET("lw9qf")
    Call<CityJSONResponse> getJSON();
}
