
package com.example.tour_guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import POJO.POJOTransport;

public class Transport_Adaptor extends RecyclerView.Adapter<Transport_Adaptor.ViewHolder> {
    Context context;
    ArrayList<POJOTransport> pojoTransport;

    public Transport_Adaptor(Context context, ArrayList<POJOTransport> pojoTransport) {
        this.context = context;
        this.pojoTransport = pojoTransport;
    }

    @NonNull
    @Override
    public Transport_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.api_single_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Transport_Adaptor.ViewHolder holder, int position) {
        POJOTransport item = pojoTransport.get(position);
        holder.TouristPL.setText("Tourist Place" + (""));
        holder.TouristAG.setText("Tourist Agencies" + (""));
        holder.Domestic.setText("Domestic" + (""));
    }

    @Override
    public int getItemCount() {
        return pojoTransport.size();
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
