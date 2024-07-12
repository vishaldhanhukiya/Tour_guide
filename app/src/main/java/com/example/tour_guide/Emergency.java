package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import POJO.POJOEmergency;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Emergency extends AppCompatActivity {

    RecyclerView RVEM;
    Emergency_Adaptor EMAdptr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        RVEM = findViewById(R.id.RVEM);
        getapicall8(1, 2, 3);
    }

    public void getapicall8(int username, int email, int name) {
        Call<ArrayList<POJOEmergency>> call = APIClient.getTryCatchInterface().getNewData8(username, email, name);
        call.enqueue(new Callback<ArrayList<POJOEmergency>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOEmergency>> call, Response<ArrayList<POJOEmergency>> response) {
                if (response.code() == 200 && response.body() != null) {
                    EMAdptr = new Emergency_Adaptor(Emergency.this, response.body());
                    RVEM.setLayoutManager(new LinearLayoutManager(Emergency.this));
                    RVEM.setAdapter(EMAdptr);
                } else if (response.code() == 401) {
                    Toast.makeText(Emergency.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Emergency.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOEmergency>> call, Throwable t) {
                Toast.makeText(Emergency.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}