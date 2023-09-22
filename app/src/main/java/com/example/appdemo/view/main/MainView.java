package com.example.appdemo.view.main;

import com.example.appdemo.model.WeatherCurrent;

public interface MainView {
    void GetWeatherSucces(WeatherCurrent weathercurent);
    void Loading();
    void GetWeatherFail();
}
