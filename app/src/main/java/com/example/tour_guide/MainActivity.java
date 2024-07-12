package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView Transport, FandD, Hotel, Shopping, Eduction, Public, Tourist, ATM, Emergency;
    TextView txt, txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
    CardView card1, card2, card3, card4, card5, card6, card7, card8, card9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Transport = findViewById(R.id.Transport);
        FandD = findViewById(R.id.FandD);
        Hotel = findViewById(R.id.Hotel);
        Shopping = findViewById(R.id.Shopping);
        Eduction = findViewById(R.id.Eduction);
        Public = findViewById(R.id.Public);
        Tourist = findViewById(R.id.Tourist);
        ATM = findViewById(R.id.ATM);
        Emergency = findViewById(R.id.Emergency);
        txt = findViewById(R.id.txt);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txt8 = findViewById(R.id.txt8);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        card9 = findViewById(R.id.card9);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Transport.class);
                startActivity(intent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FandD.class);
                startActivity(intent);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Hotel.class);
                startActivity(intent);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Shopping.class);
                startActivity(intent);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Education.class);
                startActivity(intent);
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Service.class);
                startActivity(intent);
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tourist.class);
                startActivity(intent);
            }
        });
        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.tour_guide.ATM.class);
                startActivity(intent);
            }
        });
        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Emergency.class);
                startActivity(intent);
            }
        });
    }
}