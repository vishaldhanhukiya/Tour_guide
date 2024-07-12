package com.example.tour_guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import POJO.POJOService;


public class Service_Adaptor extends RecyclerView.Adapter<Service_Adaptor.ViewHolder> {
    Context context;
    ArrayList<POJOService> pojoService;

    public Service_Adaptor(Context context, ArrayList<POJOService> pojoService) {
        this.context = context;
        this.pojoService = pojoService;
    }

    @NonNull
    @Override
    public Service_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.servicesinglerow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Service_Adaptor.ViewHolder holder, int position) {
        POJOService item = pojoService.get(position);
        holder.Social_Orgs.setText("Social Organizations" + (""));
        holder.Petrol_Sts.setText("Petrol Stations" + (""));
        holder.Medi_St.setText("Medical Store" + (""));
        holder.Industries.setText("Industries" + (""));
        holder.Hospital.setText("Hospital" + (""));
        holder.Govt_Off.setText("Govt Offices"+(""));
        holder.Essentials.setText("Essentials"+(""));
    }

    @Override
    public int getItemCount() {
        return pojoService.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Social_Orgs;
        TextView Petrol_Sts;
        TextView Medi_St;
        TextView Industries;
        TextView Hospital;
        TextView Govt_Off;
        TextView Essentials;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Social_Orgs = itemView.findViewById(R.id.Social_Orgs);
            Petrol_Sts = itemView.findViewById(R.id.Petrol_Sts);
            Medi_St = itemView.findViewById(R.id.Medi_St);
            Industries = itemView.findViewById(R.id.Industries);
            Hospital = itemView.findViewById(R.id.Hospital);
            Govt_Off = itemView.findViewById(R.id.Govt_Off);
            Essentials = itemView.findViewById(R.id.Essentials);
        }
    }
}
