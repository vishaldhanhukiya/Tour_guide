package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tour_guide.models.FoodDrinks;

import java.util.ArrayList;

import POJO.POJOFandD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class coldActivity extends AppCompatActivity {

    RecyclerView RVC;
    TextView abc;

    FandD_Category_Adaptor skAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold);
        RVC = findViewById(R.id.rvcold);
        abc = findViewById(R.id.abc);
        getNewDataSN1(1);
    }

    public void getNewDataSN1(int CategoryId) {
        Call<ArrayList<FoodDrinks>> call = APIClient.getTryCatchInterface().getNewDataSN1(CategoryId);
        call.enqueue(new Callback<ArrayList<FoodDrinks>>() {
            @Override
            public void onResponse(Call<ArrayList<FoodDrinks>> call, Response<ArrayList<FoodDrinks>> response) {
                if (response.code() == 200 && response.body() != null) {
                   // snacks_Adaptor snacksAdaptor= new snacks_Adaptor(cold.this,response.body());
                   // RVC.setLayoutManager(new LinearLayoutManager(cold.this));
                   // RVC.setAdapter(snacksAdaptor);
                    Log.d("API_SUCCESS", "Data received successfully");
                } else if (response.code() == 401) {
                    Toast.makeText(coldActivity.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                    Log.e("API_ERROR", "Unauthorized: " + response.message());
                } else {
                    Toast.makeText(coldActivity.this, "Authorized", Toast.LENGTH_SHORT).show();
                    Log.e("API_ERROR", "Authorized: " + response.message());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<FoodDrinks>> call, Throwable t) {
                Toast.makeText(coldActivity.this, "check your internet connection ", Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = getIntent();

        if (intent != null) {
            String ame = intent.getStringExtra("name");

            if (ame != null) {
                abc.setText(ame);
            }
        }
    }
}