package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.appdemo.databinding.ActivityDetailBinding;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

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
}