package com.example.tour_guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import POJO.POJOFandD;
import POJO.POJOHotel;

public class Hotel_Adaptor extends RecyclerView.Adapter<Hotel_Adaptor.ViewHolder> {
    Context context;
    ArrayList<POJOHotel> pojoHotel;

    public Hotel_Adaptor(Context context, ArrayList<POJOHotel> pojoHotel) {
        this.context = context;
        this.pojoHotel = pojoHotel;
    }

    @NonNull
    @Override
    public Hotel_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotelsinglerow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hotel_Adaptor.ViewHolder holder, int position) {
        POJOHotel item = pojoHotel.get(position);
        holder.Restaurant.setText("Restaurant" + (""));
        holder.Permit_room.setText("Permit room" + (""));
        holder.Hotels.setText("Hotels" + (""));
    }

    @Override
    public int getItemCount() {
        return pojoHotel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Restaurant;
        TextView Permit_room;
        TextView Hotels;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Restaurant = itemView.findViewById(R.id.Restaurant);
            Permit_room = itemView.findViewById(R.id.Permit_room);
            Hotels = itemView.findViewById(R.id.Hotels);
        }
    }
}
