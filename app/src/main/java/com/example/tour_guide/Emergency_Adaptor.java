package com.example.tour_guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import POJO.POJOEmergency;
import POJO.POJOTransport;

public class Emergency_Adaptor extends RecyclerView.Adapter<Emergency_Adaptor.ViewHolder> {
    Context context;
    ArrayList<POJOEmergency> pojoEmergency;

    public Emergency_Adaptor(Context context, ArrayList<POJOEmergency> pojoEmergency) {
        this.context = context;
        this.pojoEmergency = pojoEmergency;
    }

    @NonNull
    @Override
    public Emergency_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.emergencysinglerow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Emergency_Adaptor.ViewHolder holder, int position) {
        POJOEmergency item = pojoEmergency.get(position);
        holder.Ambulance.setText("Ambulance" + (""));
        holder.Bld_bank.setText("Blood bank" + (""));
        holder.Police.setText("Police" + (""));
    }

    @Override
    public int getItemCount() {
        return pojoEmergency.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Ambulance;
        TextView Bld_bank;
        TextView Police;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Ambulance = itemView.findViewById(R.id.Ambulance);
            Bld_bank = itemView.findViewById(R.id.Bld_bank);
            Police = itemView.findViewById(R.id.Police);
        }
    }
}
