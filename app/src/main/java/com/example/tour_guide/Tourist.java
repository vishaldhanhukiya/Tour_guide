package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import POJO.POJOTourist;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tourist extends AppCompatActivity {

    RecyclerView RVTO;
    Tourist_Adaptor TRAdptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist);
        RVTO = findViewById(R.id.RVTO);
        getapicall9(1, 2);
    }

    public void getapicall9(int id, int cat_name) {
        Call<ArrayList<POJOTourist>> call = APIClient.getTryCatchInterface().getNewData9(id, cat_name);
        call.enqueue(new Callback<ArrayList<POJOTourist>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOTourist>> call, Response<ArrayList<POJOTourist>> response) {
                if (response.code() == 200 && response.body() != null) {
                    TRAdptr = new Tourist_Adaptor(Tourist.this, response.body());
                    RVTO.setLayoutManager(new LinearLayoutManager(Tourist.this));
                    RVTO.setAdapter(TRAdptr);
                } else if (response.code() == 401) {
                    Toast.makeText(Tourist.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Tourist.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOTourist>> call, Throwable t) {
                Toast.makeText(Tourist.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}