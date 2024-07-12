package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import POJO.POJOEducation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Education extends AppCompatActivity {

    RecyclerView RVED;
    Education_Adaptor EDAdptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        RVED = findViewById(R.id.RVED);
        getapicall4(1, 2, 3);
    }

    public void getapicall4(int user_name, int name, int email) {
        Call<ArrayList<POJOEducation>> call = APIClient.getTryCatchInterface().getNewData4(user_name, email, name);
        call.enqueue(new Callback<ArrayList<POJOEducation>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOEducation>> call, Response<ArrayList<POJOEducation>> response) {
                if (response.code() == 200 && response.body() != null) {
                    EDAdptr = new Education_Adaptor(Education.this, response.body());
                    RVED.setLayoutManager(new LinearLayoutManager(Education.this));
                    RVED.setAdapter(EDAdptr);
                } else if (response.code() == 401) {
                    Toast.makeText(Education.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Education.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOEducation>> call, Throwable t) {
                Toast.makeText(Education.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}