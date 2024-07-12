package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tour_guide.models.FoodDrinks;

import java.util.ArrayList;

import POJO.POJOFandD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class snacksActivity extends AppCompatActivity {

    RecyclerView rv;
    FandD_Category_Adaptor skAdaptor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
        rv = findViewById(R.id.rv);
        getNewDataSN1(1);
    }

    public void getNewDataSN1(int CategoryId) {
        // se you are passing wrong pojo
        // check the reposense first and then create pojo according to that
        Call<ArrayList<FoodDrinks>> call = APIClient.getTryCatchInterface().getNewDataSN1(CategoryId);
        call.enqueue(new Callback<ArrayList<FoodDrinks>>() {
            @Override
            public void onResponse(Call<ArrayList<FoodDrinks>> call, Response<ArrayList<FoodDrinks>> response) {
                if (response.code() == 200 && response.body() != null) {
                   /* snacks_Adaptor snacksAdaptor= new snacks_Adaptor(snacksActivity.this,response.body());
                    rv.setLayoutManager(new LinearLayoutManager(snacksActivity.this));
                    rv.setAdapter(snacksAdaptor);*/
                    Log.d("API_SUCCESS", "Data received successfully");
                } else if (response.code() == 401) {
                    Toast.makeText(snacksActivity.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                    Log.e("API_ERROR", "Unauthorized: " + response.message());
                } else {
                    Toast.makeText(snacksActivity.this, "Authorized", Toast.LENGTH_SHORT).show();
                    Log.e("API_ERROR", "Authorized: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FoodDrinks>> call, Throwable t) {
                Toast.makeText(snacksActivity.this, "check your internet connection ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}