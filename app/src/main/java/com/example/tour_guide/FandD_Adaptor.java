package com.example.tour_guide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import POJO.POJOFandD;

public class FandD_Adaptor extends RecyclerView.Adapter<FandD_Adaptor.ViewHolder> {
    Context context;
    ArrayList<POJOFandD> pojoFandD;

    public FandD_Adaptor(Context context, ArrayList<POJOFandD> pojoFandD) {
        this.context = context;
        this.pojoFandD = pojoFandD;
    }

    @NonNull
    @Override
    public FandD_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.foodsinglerow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FandD_Adaptor.ViewHolder holder, int position) {
        POJOFandD item = pojoFandD.get(position);
        holder.ColdDrinks.setText("Cold Drinks" + (""));
        holder.SnackCenters.setText("Snack Centers" + (""));
        holder.SnackCenters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, snacksActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pojoFandD.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ColdDrinks;
        TextView SnackCenters;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ColdDrinks = itemView.findViewById(R.id.Cold_Drinks);
            SnackCenters = itemView.findViewById(R.id.Snack_Centers);
        }
    }
}
