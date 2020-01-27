package com.example.flobizassignment.model.city;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CityClient {
    private CityApi cityApi;
    private static CityClient INSTANCE;

    private CityClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(CityApi.CITY_URL).addConverterFactory(GsonConverterFactory.create()).build();

        cityApi = retrofit.create(CityApi.class);
    }

    public static CityClient getINSTANCE(){
        if (null == INSTANCE){
            INSTANCE = new CityClient();
        }
        return INSTANCE;
    }

    public Call<CityJSONResponse> getJSON(){
        return cityApi.getJSON();
    }
}
