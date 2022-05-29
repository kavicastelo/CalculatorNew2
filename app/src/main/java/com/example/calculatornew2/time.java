package com.example.calculatornew2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class time extends AppCompatActivity {

    TextView l1, l2, l3, l4, l5, l6, l7, l8, l9, l0, lp;
    Button ac, clear;
    EditText etl1, etl2;
    ImageButton back;
    Spinner lSpin1, lSpin2;
    float originalValue, convertValue;
    String Clear;
    boolean Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        l1=findViewById(R.id.T1);
        l2=findViewById(R.id.T2);
        l3=findViewById(R.id.T3);
        l4=findViewById(R.id.T4);
        l5=findViewById(R.id.T5);
        l6=findViewById(R.id.T6);
        l7=findViewById(R.id.T7);
        l8=findViewById(R.id.T8);
        l9=findViewById(R.id.T9);
        l0=findViewById(R.id.T0);
        lp=findViewById(R.id.point);

        ac=findViewById(R.id.btnac);
        clear=findViewById(R.id.btnclear);

        etl1=findViewById(R.id.txt1);
        etl2=findViewById(R.id.txt2);

        back=findViewById(R.id.btnback);

        lSpin1=findViewById(R.id.spin1);
        lSpin2=findViewById(R.id.spin2);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        etl1.requestFocus();
        etl2.requestFocus();

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"1");
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"2");
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"3");
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"4");
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"5");
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"6");
            }
        });
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"8");
            }
        });
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"8");
            }
        });
        l9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"9");
            }
        });
        l0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+"0");
            }
        });
        lp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(etl1.getText()+".");
            }
        });

        etl1.setText(String.valueOf(convertValue));
        originalValue = Float.parseFloat(etl1.getText().toString());
        if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("s"))
        {
            convertValue = originalValue;
        }
        if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("min"))
        {
            convertValue = originalValue/60;
        }
        if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("h"))
        {
            convertValue = originalValue/60/60;
        }
        if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("day"))
        {
            convertValue = originalValue/60/60/24;
        }
        if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("week"))
        {
            convertValue = originalValue/60/60/24/7;
        }
        if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("month"))
        {
            convertValue = originalValue/60/60/24/7/4;
        }
        if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("year"))
        {
            convertValue = originalValue/60/60/24/7/4/12;
        }
        if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("s"))
        {
            convertValue = originalValue*60;
        }
        if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("min"))
        {
            convertValue = originalValue;
        }
        if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("h"))
        {
            convertValue = originalValue/60;
        }
        if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("day"))
        {
            convertValue = originalValue/60/24;
        }
        if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("week"))
        {
            convertValue = originalValue/60/24/7;
        }
        if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("month"))
        {
            convertValue = originalValue/60/24/7/4;
        }
        if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("year"))
        {
            convertValue = originalValue/60/24/7/4/12;
        }
        if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("s"))
        {
            convertValue = originalValue*60*60;
        }
        if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("min"))
        {
            convertValue = originalValue*60;
        }
        if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("h"))
        {
            convertValue = originalValue;
        }
        if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("day"))
        {
            convertValue = originalValue/24;
        }
        if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("week"))
        {
            convertValue = originalValue/24/7;
        }
        if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("month"))
        {
            convertValue = originalValue/24/7/4;
        }
        if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("year"))
        {
            convertValue = originalValue/24/7/4/12;
        }
        if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("s"))
        {
            convertValue = originalValue*60*60*24;
        }
        if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("min"))
        {
            convertValue = originalValue*60*24;
        }
        if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("h"))
        {
            convertValue = originalValue*24;
        }
        if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("day"))
        {
            convertValue = originalValue;
        }
        if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("week"))
        {
            convertValue = originalValue/7;
        }
        if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("month"))
        {
            convertValue = originalValue/7/4;
        }
        if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("year"))
        {
            convertValue = originalValue/7/4/12;
        }
        if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("s"))
        {
            convertValue = originalValue*60*60*24*7;
        }
        if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("min"))
        {
            convertValue = originalValue*60*24*7;
        }
        if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("h"))
        {
            convertValue = originalValue*24*7;
        }
        if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("day"))
        {
            convertValue = originalValue*7;
        }
        if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("week"))
        {
            convertValue = originalValue;
        }
        if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("month"))
        {
            convertValue = originalValue/4;
        }
        if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("year"))
        {
            convertValue = originalValue/4/12;
        }
        if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("s"))
        {
            convertValue = originalValue*60*60*24*7*4;
        }
        if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("min"))
        {
            convertValue = originalValue*60*24*7*4;
        }
        if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("h"))
        {
            convertValue = originalValue*24*7*4;
        }
        if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("day"))
        {
            convertValue = originalValue*24*7*4;
        }
        if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("week"))
        {
            convertValue = originalValue*7*4;
        }
        if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("month"))
        {
            convertValue = originalValue*12;
        }
        if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("month"))
        {
            convertValue = originalValue;
        }
        if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("year"))
        {
            convertValue = originalValue/12;
        }
        if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("s"))
        {
            convertValue = originalValue*60*60*24*7*4*12;
        }
        if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("min"))
        {
            convertValue = originalValue*60*24*7*4*12;
        }
        if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("h"))
        {
            convertValue = originalValue*24*7*4*12;
        }
        if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("day"))
        {
            convertValue = originalValue*7*4*12;
        }
        if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("week"))
        {
            convertValue = originalValue*4*12;
        }
        if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("month"))
        {
            convertValue = originalValue*12;
        }
        if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("year"))
        {
            convertValue = originalValue;
        }

        lSpin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                originalValue = Float.parseFloat(etl1.getText().toString());
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue/60;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue/60/60;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue/60/60/24;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue/60/60/24/7;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/60/60/24/7/4;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/60/60/24/7/4/12;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue/60;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue/60/24;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue/60/24/7;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/60/24/7/4;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/60/24/7/4/12;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue/24;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue/24/7;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/24/7/4;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/24/7/4/12;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60*24;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60*24;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue*24;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue/7;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/7/4;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/7/4/12;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60*24*7;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60*24*7;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue*24*7;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue*7;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/4;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/4/12;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60*24*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60*24*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue*24*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue*24*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue*12;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60*24*7*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60*24*7*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue*24*7*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue*7*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue;
                }
                etl2.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                originalValue = Float.parseFloat(etl1.getText().toString());
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue/60;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue/60/60;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue/60/60/24;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue/60/60/24/7;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/60/60/24/7/4;
                }
                if(lSpin1.getSelectedItem().equals("s") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/60/60/24/7/4/12;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue/60;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue/60/24;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue/60/24/7;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/60/24/7/4;
                }
                if(lSpin1.getSelectedItem().equals("min") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/60/24/7/4/12;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue/24;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue/24/7;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/24/7/4;
                }
                if(lSpin1.getSelectedItem().equals("h") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/24/7/4/12;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60*24;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60*24;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue*24;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue/7;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/7/4;
                }
                if(lSpin1.getSelectedItem().equals("day") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/7/4/12;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60*24*7;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60*24*7;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue*24*7;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue*7;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue/4;
                }
                if(lSpin1.getSelectedItem().equals("week") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/4/12;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60*24*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60*24*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue*24*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue*24*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue*7*4;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue*12;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue;
                }
                if(lSpin1.getSelectedItem().equals("month") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue/12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("s"))
                {
                    convertValue = originalValue*60*60*24*7*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("min"))
                {
                    convertValue = originalValue*60*24*7*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("h"))
                {
                    convertValue = originalValue*24*7*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("day"))
                {
                    convertValue = originalValue*7*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("week"))
                {
                    convertValue = originalValue*4*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("month"))
                {
                    convertValue = originalValue*12;
                }
                if(lSpin1.getSelectedItem().equals("year") && lSpin2.getSelectedItem().equals("year"))
                {
                    convertValue = originalValue;
                }
                etl2.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etl1.setText(null);
                etl2.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etl1.getText().toString().equals(""))
                {
                    etl1.setText("");
                }
                else
                {
                    Clear = etl1.getText().toString();
                    Back = true;
                    etl1.setText(Clear.substring(0,Clear.length()-1));
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(time.this,frm2.class);
                startActivity(i);
            }
        });
    }
}