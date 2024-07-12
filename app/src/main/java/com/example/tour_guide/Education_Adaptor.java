package com.example.tour_guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import POJO.POJOEducation;


public class Education_Adaptor extends RecyclerView.Adapter<Education_Adaptor.ViewHolder> {
    Context context;
    ArrayList<POJOEducation> pojoEducations;

    public Education_Adaptor(Context context, ArrayList<POJOEducation> pojoEducations) {
        this.context = context;
        this.pojoEducations = pojoEducations;
    }

    @NonNull
    @Override
    public Education_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.educationsinglerow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Education_Adaptor.ViewHolder holder, int position) {
        POJOEducation item = pojoEducations.get(position);

        holder.Schools.setText("Schools" + (""));
        holder.Colleges.setText("Colleges" + (""));
        holder.Tr_Ins.setText("Training Institutes" + (""));
        holder.Tu_Cls.setText("Tuition Classes"+(""));
        holder.Pri_Tus.setText("Private Tutors"+(""));
    }

    @Override
    public int getItemCount() {
        return pojoEducations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Schools;
        TextView Colleges;
        TextView Tr_Ins;
        TextView Tu_Cls;
        TextView Pri_Tus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Schools = itemView.findViewById(R.id.Schools);
            Colleges = itemView.findViewById(R.id.Colleges);
            Tr_Ins = itemView.findViewById(R.id.Tr_Ins);
            Tu_Cls = itemView.findViewById(R.id.Tu_Cls);
            Pri_Tus = itemView.findViewById(R.id.Pri_Tus);
        }
    }
}
