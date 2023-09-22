package com.example.appdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appdemo.R;
import com.example.appdemo.databinding.ActivityHomeBinding;
import com.example.appdemo.model.WeatherCurrent;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private Calendar calendar =Calendar.getInstance();
    private WeatherCurrent Weathercurrent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SetUpHomeActivity();

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("weathercurent", Weathercurrent);
                startActivity(intent);
            }
        });
    }

    void SetUpHomeActivity(){
        Intent intent = getIntent();
        Weathercurrent = (WeatherCurrent) intent.getSerializableExtra("weathercurent");
        binding.tvCelsius.setText((int)(Weathercurrent.getMain().getTemp() - 273.15) + "°C");
        binding.tvDescription.setText(Weathercurrent.getWeather().get(0).getDescription());
        binding.tvCelsiusMaxMin.setText("Max " + (int)(Weathercurrent.getMain().getTemp_max()- 273.15) + "°C" + "  Min " +  (int)(Weathercurrent.getMain().getTemp_min() - 273.15)+ "°C" );
        binding.tvToDay.setText(ConvertMonth(calendar.get(Calendar.MONTH)) + ", " + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        binding.ivWeather.setImageResource(ConvertIconWeather(Weathercurrent.getWeather().get(0).getMain()));
    }

    String ConvertMonth(int Month){
        switch (Month){
            case 0: return  "Jan";
            case 1: return  "Feb";
            case 2: return  "Mar";
            case 3: return  "Apr";
            case 4: return  "May";
            case 5: return  "Jun";
            case 6: return  "July";
            case 7: return  "August";
            case 8: return  "September";
            case 9: return  "October";
            case 10: return  "November";
            case 11: return  "December";
        }
        return "";
    }

    int ConvertIconWeather(String main){
        switch (main){
            case "Clouds" : return R.drawable.cloud;
            case "Drizzle" : return R.drawable.cloud;
            case  "Rain" : return  R.drawable.rain;
            case "Clear" : return R.drawable.clear;
            case "Snow" : return  R.drawable.snow;
        }
        return R.drawable.cloud;
    }
}