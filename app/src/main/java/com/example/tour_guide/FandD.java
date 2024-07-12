package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import POJO.POJOFandD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FandD extends AppCompatActivity {
    RecyclerView RVFD;
    FandD_Adaptor FDAdptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fand_d);
        RVFD = findViewById(R.id.RVFD);
        getapicall1(1, 2, 3);
    }

    public void getapicall1(int username, int email, int name) {
        Call<ArrayList<POJOFandD>> call = APIClient.getTryCatchInterface().getNewDataFandD(username, email, name);
        call.enqueue(new Callback<ArrayList<POJOFandD>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOFandD>> call, Response<ArrayList<POJOFandD>> response) {
                if (response.code() == 200 && response.body() != null) {
                    FDAdptr = new FandD_Adaptor(FandD.this, response.body());
                    RVFD.setLayoutManager(new LinearLayoutManager(FandD.this));
                    RVFD.setAdapter(FDAdptr);
                } else if (response.code() == 401) {
                    Toast.makeText(FandD.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FandD.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOFandD>> call, Throwable t) {
                Toast.makeText(FandD.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
