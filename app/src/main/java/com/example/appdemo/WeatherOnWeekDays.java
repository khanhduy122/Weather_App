package com.example.appdemo;

public class WeatherOnWeekDays {
    private int Temperature;
    private int Imgweather;
    private WeekDaysEnum weekDays;

    public WeatherOnWeekDays(int temperature, int imgweather, WeekDaysEnum weekDays) {
        Temperature = temperature;
        Imgweather = imgweather;
        this.weekDays = weekDays;
    }

    public int getTemperature() {
        return Temperature;
    }

    public void setTemperature(int temperature) {
        Temperature = temperature;
    }

    public int getImgweather() {
        return Imgweather;
    }

    public void setImgweather(int imgweather) {
        Imgweather = imgweather;
    }

    public WeekDaysEnum getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(WeekDaysEnum weekDays) {
        this.weekDays = weekDays;
    }


}

enum WeekDaysEnum{Mon, Tue, Wed, Thu, Fri, Sat, Sun}
