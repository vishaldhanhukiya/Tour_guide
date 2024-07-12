package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import POJO.POJOATM;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ATM extends AppCompatActivity {
    RecyclerView RVATM;
    ATM_Adaptor ATMAdptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm);
        RVATM = findViewById(R.id.RVATM);
        getapicall7(1, 2, 3);
    }

    public void getapicall7(int username, int email, int name) {
        Call<ArrayList<POJOATM>> call = APIClient.getTryCatchInterface().getNewData7(username, email, name);
        call.enqueue(new Callback<ArrayList<POJOATM>>() {
            @Override
            public void onResponse(Call<ArrayList<POJOATM>> call, Response<ArrayList<POJOATM>> response) {
                if (response.code() == 200 && response.body() != null) {
                    ATMAdptr = new ATM_Adaptor(ATM.this, response.body());
                    RVATM.setLayoutManager(new LinearLayoutManager(ATM.this));
                    RVATM.setAdapter(ATMAdptr);
                } else if (response.code() == 401) {
                    Toast.makeText(ATM.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ATM.this, "Authorized", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<POJOATM>> call, Throwable t) {
                Toast.makeText(ATM.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}