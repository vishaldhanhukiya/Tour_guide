package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import POJO.POJOTransport;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Transport extends AppCompatActivity {

    RecyclerView RVTR;
    Transport_Adaptor TRAdptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        RVTR = findViewById(R.id.RVTR);
        getapicall(1, 2);
    }

    public void getapicall(int id, int cat_name) {
        Call<ArrayList<POJOTransport>> call = APIClient.getTryCatchInterface().getNewData(id, cat_name);
        call.enqueue(new Callback<ArrayList<POJOTransport>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOTransport>> call, Response<ArrayList<POJOTransport>> response) {
                if (response.code() == 200 && response.body() != null) {
                    TRAdptr = new Transport_Adaptor(Transport.this, response.body());
                    RVTR.setLayoutManager(new LinearLayoutManager(Transport.this));
                    RVTR.setAdapter(TRAdptr);
                } else if (response.code() == 401) {
                    Toast.makeText(Transport.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Transport.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOTransport>> call, Throwable t) {
                Toast.makeText(Transport.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
