package com.example.appdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;
import com.example.appdemo.model.WeatherOnWeekDays;

public class RvCustomAdapter extends RecyclerView.Adapter<RvCustomAdapter.ViewHolder> {

    WeatherOnWeekDays[] Weatheronweekdays;

    public RvCustomAdapter(WeatherOnWeekDays[] Weatheronweekdays) {
        this.Weatheronweekdays = Weatheronweekdays;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView Tvtemperature;
        private ImageView Ivweather;
        private TextView TvweekDays;

        public ViewHolder(@NonNull View Itemview) {
            super(Itemview);
            Tvtemperature = itemView.findViewById(R.id.tvTemperature);
            Ivweather = itemView.findViewById(R.id.ivWeather);
            TvweekDays = itemView.findViewById(R.id.tvWeekDays);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int Viewtype) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_weather_on_weekdays, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Tvtemperature.setText(Weatheronweekdays[position].getTemperature() + "°C");
        holder.Ivweather.setImageResource((Weatheronweekdays[position].getImgweather()));
        holder.TvweekDays.setText(Weatheronweekdays[position].getWeekDays().toString());
    }

    @Override
    public int getItemCount() {
        return 7;
    }


}
