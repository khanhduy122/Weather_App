package com.example.appdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Main implements Serializable {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private int pressure;
    private  int humidity;
    private int sea_level;
    private  int grnd_level;

    public Main(Double temp, Double feels_like, Double temp_min, Double temp_max, int pressure, int humidity, int sea_level, int grnd_level) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
    }

    protected Main(Parcel in) {
        if (in.readByte() == 0) {
            temp = null;
        } else {
            temp = in.readDouble();
        }
        if (in.readByte() == 0) {
            feels_like = null;
        } else {
            feels_like = in.readDouble();
        }
        if (in.readByte() == 0) {
            temp_min = null;
        } else {
            temp_min = in.readDouble();
        }
        if (in.readByte() == 0) {
            temp_max = null;
        } else {
            temp_max = in.readDouble();
        }
        pressure = in.readInt();
        humidity = in.readInt();
        sea_level = in.readInt();
        grnd_level = in.readInt();
    }


    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Double feels_like) {
        this.feels_like = feels_like;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getSea_level() {
        return sea_level;
    }

    public void setSea_level(int sea_level) {
        this.sea_level = sea_level;
    }

    public int getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(int grnd_level) {
        this.grnd_level = grnd_level;
    }
}
