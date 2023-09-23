package com.example.appdemo.view.main;

import android.location.Location;

import com.example.appdemo.model.WeatherCurrent;

public interface MainView {
    void GetWeatherSucces(WeatherCurrent weathercurent);
    void GetWeatherFail();
    void NoInternetErro();
    void Loading();
}
