package com.example.tour_guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import POJO.POJOATM;


public class ATM_Adaptor extends RecyclerView.Adapter<ATM_Adaptor.ViewHolder> {

    Context context;
    ArrayList<POJOATM> pojoatm;

    public ATM_Adaptor(Context context, ArrayList<POJOATM> pojoatm) {
        this.context = context;
        this.pojoatm = pojoatm;
    }

    @NonNull
    @Override
    public ATM_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.atmsinglerow, parent, false);
        return new ATM_Adaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ATM_Adaptor.ViewHolder holder, int position) {
       POJOATM item = pojoatm.get(position);
        holder.ATM.setText("ATM" + (""));

    }

    @Override
    public int getItemCount() {
        return pojoatm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ATM;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ATM = itemView.findViewById(R.id.ATM);
        }
    }
}
