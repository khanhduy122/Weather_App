package com.example.appdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Coord implements Serializable {
    private float lon;
    private float lat;

    protected Coord(Parcel in) {
        lon = in.readFloat();
        lat = in.readFloat();
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

}
