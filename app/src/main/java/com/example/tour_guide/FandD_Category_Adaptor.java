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
import java.util.List;

import POJO.POJOFandD;

public class FandD_Category_Adaptor extends RecyclerView.Adapter<FandD_Category_Adaptor.ViewHolder> {
    Context context;
    List<POJOFandD> pojoFandD;

    public FandD_Category_Adaptor(Context context, ArrayList<POJOFandD> pojoFandD) {
        this.context = context;
        this.pojoFandD = pojoFandD;
    }

    @NonNull
    @Override
    public FandD_Category_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.snackssinglerow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FandD_Category_Adaptor.ViewHolder holder, int position) {
        POJOFandD item = pojoFandD.get(position);
        holder.snack_view.setText((item.getName()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, coldActivity.class);
                intent.putExtra("name", item.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pojoFandD.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //        RecyclerView sn_rv;
        TextView snack_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            sn_rv = itemView.findViewById(R.id.sn_rv);
            snack_view = itemView.findViewById(R.id.snack_view);
        }
    }
}
