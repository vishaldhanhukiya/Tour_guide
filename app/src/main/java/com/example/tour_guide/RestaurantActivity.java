/*
package com.example.tour_guide;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import POJO.POJOFandD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantActivity extends AppCompatActivity {

    RecyclerView rv;
    Hotel_Category_Adaptor hoAdaptor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
        rv = findViewById(R.id.rv);
        getNewDataSN1(1);
    }

    public void getNewDataSN1(int CategoryId) {
        Call<ArrayList<POJOFandD>> call = APIClient.getTryCatchInterface().getNewDataSN1(CategoryId);
        call.enqueue(new Callback<ArrayList<POJOFandD>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOFandD>> call, Response<ArrayList<POJOFandD>> response) {
                if (response.code() == 200 && response.body() != null) {
                   */
/* snacks_Adaptor snacksAdaptor= new snacks_Adaptor(snacksActivity.this,response.body());
                    rv.setLayoutManager(new LinearLayoutManager(snacksActivity.this));
                    rv.setAdapter(snacksAdaptor);*//*

                    Log.d("API_SUCCESS", "Data received successfully");
                } else if (response.code() == 401) {
                    Toast.makeText(RestaurantActivity.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                    Log.e("API_ERROR", "Unauthorized: " + response.message());
                } else {
                    Toast.makeText(RestaurantActivity.this, "Authorized", Toast.LENGTH_SHORT).show();
                    Log.e("API_ERROR", "Authorized: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOFandD>> call, Throwable t) {
                Toast.makeText(RestaurantActivity.this, "check your internet connection ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}*/
