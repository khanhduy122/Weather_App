package com.example.appdemo.view.main;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.appdemo.api.ApiGetWeatherCurrent;
import com.example.appdemo.model.WeatherCurrent;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainView Mainview;
    private Context context;
    private FusedLocationProviderClient fusedLocationClient;

    public MainPresenter(Context context, MainView mainview) {
        this.context = context;
        Mainview = mainview;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
    }

    public void CallApiGetWeatherCurrent(String Appid,  double lat, double lon){
        ApiGetWeatherCurrent.Apigetweathercurrent.Getweathercurrent(lat, lon, Appid).enqueue(new Callback<WeatherCurrent>() {
            @Override
            public void onResponse(Call<WeatherCurrent> call, Response<WeatherCurrent> response) {
                if(response.isSuccessful()){
                    Mainview.GetWeatherSucces(response.body());
                }
            }

            @Override
            public void onFailure(Call<WeatherCurrent> call, Throwable t) {
                Mainview.GetWeatherFail();
            }
        });
    }

}
