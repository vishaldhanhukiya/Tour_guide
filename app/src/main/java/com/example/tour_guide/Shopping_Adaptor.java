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
import POJO.POJOShopping;


public class Shopping_Adaptor extends RecyclerView.Adapter<Shopping_Adaptor.ViewHolder> {
    Context context;
    ArrayList<POJOShopping> pojoShopping;

    public Shopping_Adaptor(Context context, ArrayList<POJOShopping> pojoShopping) {
        this.context = context;
        this.pojoShopping = pojoShopping;
    }

    @NonNull
    @Override
    public Shopping_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shoppingsinglerow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Shopping_Adaptor.ViewHolder holder, int position) {
        POJOShopping item = pojoShopping.get(position);
        holder.Fashion.setText("Fashion" + (""));
        holder.Gift.setText("Gift" + (""));
        holder.Hardware.setText("Hardware" + (""));
        holder.Electronics.setText("Electronics" + (""));
    }

    @Override
    public int getItemCount() {
        return pojoShopping.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Fashion;
        TextView Gift;
        TextView Hardware;
        TextView Electronics;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Fashion = itemView.findViewById(R.id.Fashion);
            Gift = itemView.findViewById(R.id.Gift);
            Hardware = itemView.findViewById(R.id.Hardware);
            Electronics = itemView.findViewById(R.id.Electronics);
        }
    }
}
