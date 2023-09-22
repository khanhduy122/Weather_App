package com.example.appdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appdemo.R;
import com.example.appdemo.adapter.RvCustomAdapter;
import com.example.appdemo.databinding.ActivityDetailBinding;
import com.example.appdemo.model.WeatherCurrent;
import com.example.appdemo.model.WeatherOnWeekDays;
import com.example.appdemo.model.WeekDaysEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private WeatherCurrent Weathercurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setUpDetailActivity();

        WeatherOnWeekDays[] Weatheronweekdays = {
            new WeatherOnWeekDays(19, R.drawable.ic_sunny, WeekDaysEnum.Mon),
            new WeatherOnWeekDays(18, R.drawable.ic_sunny, WeekDaysEnum.Tue),
            new WeatherOnWeekDays(16, R.drawable.ic_sunny, WeekDaysEnum.Wed),
            new WeatherOnWeekDays(17, R.drawable.ic_sunny, WeekDaysEnum.Thu),
            new WeatherOnWeekDays(19, R.drawable.ic_sunny, WeekDaysEnum.Fri),
            new WeatherOnWeekDays(21, R.drawable.ic_sunny, WeekDaysEnum.Sat),
            new WeatherOnWeekDays(24, R.drawable.ic_sunny, WeekDaysEnum.Sun),
        };

        RvCustomAdapter adapter = new RvCustomAdapter(Weatheronweekdays);
        binding.rvWeatherOnWeekDay.setAdapter(adapter);
        binding.rvWeatherOnWeekDay.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    void setUpDetailActivity(){
        Intent intent = getIntent();
        Weathercurrent = (WeatherCurrent) intent.getSerializableExtra("weathercurent");
        binding.tvCity.setText(Weathercurrent.getName());
        binding.tvCelsiusMaxMin.setText("Max " + (int)(Weathercurrent.getMain().getTemp_max()- 273.15) + "°C" + "  Min " +  (int)(Weathercurrent.getMain().getTemp_min() - 273.15)+ "°C" );
        binding.tvSunrise.setText(ConvertSunRiseSunset(Weathercurrent.getSys().getSunrise()) + " AM");
        binding.tvSunset.setText(ConvertSunRiseSunset(Weathercurrent.getSys().getSunset()) + " PM");
    }

    String ConvertSunRiseSunset(long millisecondsSinceEpoch ){
        Date date = new Date(millisecondsSinceEpoch );
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
        return formatter.format(date);
    }

}