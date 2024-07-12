package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import POJO.POJOService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Service extends AppCompatActivity {

    RecyclerView RVSE;
    Service_Adaptor SRAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        RVSE = findViewById(R.id.RVSE);
        getapicall5(1, 2, 3);
    }

    public void getapicall5(int username, int email, int name) {
        Call<ArrayList<POJOService>> call = APIClient.getTryCatchInterface().getNewData5(username, email, name);
        call.enqueue(new Callback<ArrayList<POJOService>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOService>> call, Response<ArrayList<POJOService>> response) {
                if (response.code() == 200 && response.body() != null) {
                    SRAdaptor = new Service_Adaptor(Service.this, response.body());
                    RVSE.setLayoutManager(new LinearLayoutManager(Service.this));
                    RVSE.setAdapter(SRAdaptor);
                } else if (response.code() == 401) {
                    Toast.makeText(Service.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Service.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOService>> call, Throwable t) {
                Toast.makeText(Service.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}