package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import POJO.POJOShopping;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Shopping extends AppCompatActivity {

    RecyclerView RVSH;

    Shopping_Adaptor SHAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        RVSH = findViewById(R.id.RVSH);
        getapicall3(1, 2, 3);
    }

    public void getapicall3(int username, int email, int name) {
        Call<ArrayList<POJOShopping>> call = APIClient.getTryCatchInterface().getNewData3(username, email, name);
        call.enqueue(new Callback<ArrayList<POJOShopping>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOShopping>> call, Response<ArrayList<POJOShopping>> response) {
                if (response.code() == 200 && response.body() != null) {
                    SHAdaptor = new Shopping_Adaptor(Shopping.this, response.body());
                    RVSH.setLayoutManager(new LinearLayoutManager(Shopping.this));
                    RVSH.setAdapter(SHAdaptor);
                } else if (response.code() == 401) {
                    Toast.makeText(Shopping.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Shopping.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOShopping>> call, Throwable t) {
                Toast.makeText(Shopping.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}