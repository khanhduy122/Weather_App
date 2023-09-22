package com.example.appdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Sys implements Serializable {
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;

    public Sys(int type, int id, String country, long sunrise, long sunset) {
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    protected Sys(Parcel in) {
        type = in.readInt();
        id = in.readInt();
        country = in.readString();
        sunrise = in.readInt();
        sunset = in.readInt();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

}
