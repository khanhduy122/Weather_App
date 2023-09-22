package com.example.appdemo.api;

import com.example.appdemo.model.WeatherCurrent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiGetWeatherCurrent {

    ApiGetWeatherCurrent Apigetweathercurrent = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiGetWeatherCurrent.class);
    @GET("data/2.5/weather/")
    Call<WeatherCurrent> Getweathercurrent(@Query("lat") Double lat,
                                           @Query("lon") Double lon,
                                           @Query("appid") String appid);
}
