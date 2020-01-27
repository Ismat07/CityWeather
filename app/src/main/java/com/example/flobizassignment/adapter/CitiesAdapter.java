package com.example.flobizassignment.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flobizassignment.R;
import com.example.flobizassignment.model.city.City;
import com.example.flobizassignment.views.WeatherActivity;

import java.util.ArrayList;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> {

    private ArrayList<City> cityArrayList= new ArrayList<>();
    private Intent intent;
    private Context context;

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.textView.setText(cityArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return cityArrayList.size();
    }

    public void setList(ArrayList<City> cityArrayList){
        this.cityArrayList = cityArrayList  ;
        notifyDataSetChanged();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public CityViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context = view.getContext();
                    intent = new Intent(context,WeatherActivity.class);
                    intent.putExtra("cityname",cityArrayList.get(getAdapterPosition()).getName());
                    context.startActivity(intent);
                }
            });
        }
    }
}
