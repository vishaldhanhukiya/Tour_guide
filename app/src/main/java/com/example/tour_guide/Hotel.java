package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import POJO.POJOHotel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Hotel extends AppCompatActivity {
    RecyclerView RVH;
    Hotel_Adaptor HlAdptr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        RVH = findViewById(R.id.RVH);
        getNewDataHO(1, 2, 3);
    }

    public void getNewDataHO(int username, int email, int name) {
        Call<ArrayList<POJOHotel>> call = APIClient.getTryCatchInterface().getNewDataHO(username, email, name);
        call.enqueue(new Callback<ArrayList<POJOHotel>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOHotel>> call, Response<ArrayList<POJOHotel>> response) {
                if (response.code() == 200 && response.body() != null) {
                    HlAdptr = new Hotel_Adaptor(Hotel.this, response.body());
                    RVH.setLayoutManager(new LinearLayoutManager(Hotel.this));
                    RVH.setAdapter(HlAdptr);
                } else if (response.code() == 401) {
                    Toast.makeText(Hotel.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Hotel.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOHotel>> call, Throwable t) {
                Toast.makeText(Hotel.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
