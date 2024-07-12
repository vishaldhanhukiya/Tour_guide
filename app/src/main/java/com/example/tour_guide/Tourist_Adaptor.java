package com.example.tour_guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import POJO.POJOTourist;
import POJO.POJOTransport;

public class Tourist_Adaptor extends RecyclerView.Adapter<Tourist_Adaptor.ViewHolder> {

    Context context;
    ArrayList<POJOTourist> pojoTourist;

    public Tourist_Adaptor(Context context, ArrayList<POJOTourist> pojoTourist) {
        this.context = context;
        this.pojoTourist = pojoTourist;
    }

    @NonNull
    @Override
    public Tourist_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.api_single_row, parent, false);
        return new Tourist_Adaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tourist_Adaptor.ViewHolder holder, int position) {
        POJOTourist item = pojoTourist.get(position);
        holder.TouristPL.setText("Tourist Place" + (""));
        holder.TouristAG.setText("Tourist Agencies" + (""));
        holder.Domestic.setText("Domestic" + (""));

    }

    @Override
    public int getItemCount() {
        return pojoTourist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TouristPL;
        TextView TouristAG;
        TextView Domestic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TouristPL = itemView.findViewById(R.id.TouristPL);
            TouristAG = itemView.findViewById(R.id.TouristAG);
            Domestic = itemView.findViewById(R.id.Domestic);
        }
    }
}