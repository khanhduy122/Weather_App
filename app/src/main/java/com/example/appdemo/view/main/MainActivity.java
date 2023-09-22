package com.example.appdemo.view.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.appdemo.dialog.LoadingDialog;
import com.example.appdemo.view.HomeActivity;
import com.example.appdemo.databinding.ActivityMainBinding;
import com.example.appdemo.model.WeatherCurrent;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity implements MainView {
    private ActivityMainBinding Binding;



    private final String APPID = "0e63b5d011ac2f7c86b0735720ee990e";
    private final int REQUEST_CODE = 1234;
    private double lat;
    private double lon;
    FusedLocationProviderClient fusedLocationClient;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = Binding.getRoot();
        setContentView(view);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        loadingDialog = new LoadingDialog(this);
        CheckPermissionsLocation();

        MainPresenter Mainpresenter = new MainPresenter(this, this);

        Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mainpresenter.CallApiGetWeatherCurrent(APPID, lat, lon);
            }
        });

    }

    private void CheckPermissionsLocation(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    lat = location.getLatitude();
                    lon = location.getLongitude();
                    Log.d("aaa", String.valueOf(lat) + " " + String.valueOf(lon));
                }
            });
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            lat = location.getLatitude();
                            lon = location.getLongitude();

                            Log.d("aaa", String.valueOf(lat) + " " + String.valueOf(lon));
                        }
                    });
                }
            }else {
                finish();
            }
        }
    }

    @Override
    public void GetWeatherSucces(WeatherCurrent weathercurent) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("weathercurent", weathercurent);
        startActivity(intent);
        loadingDialog.dismiss();
    }

    @Override
    public void Loading() {
        loadingDialog.show();
    }

    @Override
    public void GetWeatherFail() {
    }
}