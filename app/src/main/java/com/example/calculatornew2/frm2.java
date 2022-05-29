package com.example.calculatornew2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class frm2 extends AppCompatActivity {

    ImageButton length, weight, data, temperature, bmi, time, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm2);

        length=findViewById(R.id.btnlength);
        weight=findViewById(R.id.btnweight);
        data=findViewById(R.id.btndata);
        temperature=findViewById(R.id.btntemperature);
        bmi=findViewById(R.id.btnbmi);
        time=findViewById(R.id.btntime);
        back=findViewById(R.id.frm2back);

        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Length = new Intent(frm2.this, com.example.calculatornew2.length.class);
                startActivity(Length);
            }
        });
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Weight = new Intent(frm2.this, com.example.calculatornew2.weight.class);
                startActivity(Weight);
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Data = new Intent(frm2.this, com.example.calculatornew2.data.class);
                startActivity(Data);
            }
        });
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent temp = new Intent(frm2.this, com.example.calculatornew2.temperature.class);
                startActivity(temp);
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Bmi = new Intent(frm2.this, com.example.calculatornew2.bmi.class);
                startActivity(Bmi);
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Time = new Intent(frm2.this, com.example.calculatornew2.time.class);
                startActivity(Time);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(frm2.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}