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

public class temperature extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t0, tp;
    Button ac, clear;
    EditText ett1, ett2;
    ImageButton back;
    Spinner tSpin1, tSpin2;
    float originalValue, convertValue;
    String Clear;
    boolean Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);
        t9=findViewById(R.id.t9);
        t0=findViewById(R.id.t0);
        tp=findViewById(R.id.tpoint);

        ac=findViewById(R.id.btnTac);
        clear=findViewById(R.id.btnTclear);

        ett1=findViewById(R.id.ttxt1);
        ett2=findViewById(R.id.ttxt2);

        back=findViewById(R.id.btnTback);

        tSpin1=findViewById(R.id.tspin1);
        tSpin2=findViewById(R.id.tspin2);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        ett1.requestFocus();
        ett2.requestFocus();

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"1");
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"2");
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"3");
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"4");
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"5");
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"6");
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"7");
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"8");
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"9");
            }
        });
        t0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+"0");
            }
        });
        tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(ett1.getText()+".");
            }
        });

        ett1.setText(String.valueOf(convertValue));
        originalValue=Float.parseFloat(ett1.getText().toString());
        if(tSpin1.getSelectedItem().equals("Celsius") && tSpin2.getSelectedItem().equals("Celsius"))
        {
            convertValue = originalValue;
        }
        if(tSpin1.getSelectedItem().equals("Celsius") && tSpin2.getSelectedItem().equals("Fahrenheit"))
        {
            convertValue = originalValue*(9/5)+32;
        }
        if(tSpin1.getSelectedItem().equals("Celsius") && tSpin2.getSelectedItem().equals("Kelvin"))
        {
            convertValue = originalValue+273;
        }
        if(tSpin1.getSelectedItem().equals("Fahrenheit") && tSpin2.getSelectedItem().equals("Celsius"))
        {
            convertValue = (originalValue-32)*5/9;
        }
        if(tSpin1.getSelectedItem().equals("Fahrenheit") && tSpin2.getSelectedItem().equals("Fahrenheit"))
        {
            convertValue = originalValue;
        }
        if(tSpin1.getSelectedItem().equals("Fahrenheit") && tSpin2.getSelectedItem().equals("Kelvin"))
        {
            convertValue = (float) ((float) 5/9*(originalValue+459.67));
        }
        if(tSpin1.getSelectedItem().equals("Kelvin") && tSpin2.getSelectedItem().equals("Celsius"))
        {
            convertValue = (float) (originalValue-273.15);
        }
        if(tSpin1.getSelectedItem().equals("Kelvin") && tSpin2.getSelectedItem().equals("Fahrenheit"))
        {
            convertValue = (float) ((originalValue-273.15)*1.8+32);
        }
        if(tSpin1.getSelectedItem().equals("Kelvin") && tSpin2.getSelectedItem().equals("Kelvin"))
        {
            convertValue = originalValue;
        }

        tSpin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                originalValue=Float.parseFloat(ett1.getText().toString());
                if(tSpin1.getSelectedItem().equals("Celsius") && tSpin2.getSelectedItem().equals("Celsius"))
                {
                    convertValue = originalValue;
                }
                if(tSpin1.getSelectedItem().equals("Celsius") && tSpin2.getSelectedItem().equals("Fahrenheit"))
                {
                    convertValue = originalValue*(9/5)+32;
                }
                if(tSpin1.getSelectedItem().equals("Celsius") && tSpin2.getSelectedItem().equals("Kelvin"))
                {
                    convertValue = originalValue+273;
                }
                if(tSpin1.getSelectedItem().equals("Fahrenheit") && tSpin2.getSelectedItem().equals("Celsius"))
                {
                    convertValue = (originalValue-32)*5/9;
                }
                if(tSpin1.getSelectedItem().equals("Fahrenheit") && tSpin2.getSelectedItem().equals("Fahrenheit"))
                {
                    convertValue = originalValue;
                }
                if(tSpin1.getSelectedItem().equals("Fahrenheit") && tSpin2.getSelectedItem().equals("Kelvin"))
                {
                    convertValue = (float) ((float) 5/9*(originalValue+459.67));
                }
                if(tSpin1.getSelectedItem().equals("Kelvin") && tSpin2.getSelectedItem().equals("Celsius"))
                {
                    convertValue = (float) (originalValue-273.15);
                }
                if(tSpin1.getSelectedItem().equals("Kelvin") && tSpin2.getSelectedItem().equals("Fahrenheit"))
                {
                    convertValue = (float) ((originalValue-273.15)*1.8+32);
                }
                if(tSpin1.getSelectedItem().equals("Kelvin") && tSpin2.getSelectedItem().equals("Kelvin"))
                {
                    convertValue = originalValue;
                }
                ett2.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        tSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                originalValue=Float.parseFloat(ett1.getText().toString());
                if(tSpin1.getSelectedItem().equals("Celsius") && tSpin2.getSelectedItem().equals("Celsius"))
                {
                    convertValue = originalValue;
                }
                if(tSpin1.getSelectedItem().equals("Celsius") && tSpin2.getSelectedItem().equals("Fahrenheit"))
                {
                    convertValue = (float) (originalValue*1.8+32);
                }
                if(tSpin1.getSelectedItem().equals("Celsius") && tSpin2.getSelectedItem().equals("Kelvin"))
                {
                    convertValue = (float) (originalValue+273.15);
                }
                if(tSpin1.getSelectedItem().equals("Fahrenheit") && tSpin2.getSelectedItem().equals("Celsius"))
                {
                    convertValue = (originalValue-32)*5/9;
                }
                if(tSpin1.getSelectedItem().equals("Fahrenheit") && tSpin2.getSelectedItem().equals("Fahrenheit"))
                {
                    convertValue = originalValue;
                }
                if(tSpin1.getSelectedItem().equals("Fahrenheit") && tSpin2.getSelectedItem().equals("Kelvin"))
                {
                    convertValue = (float) ((float) 5/9*(originalValue+459.67));
                }
                if(tSpin1.getSelectedItem().equals("Kelvin") && tSpin2.getSelectedItem().equals("Celsius"))
                {
                    convertValue = (float) (originalValue-273.15);
                }
                if(tSpin1.getSelectedItem().equals("Kelvin") && tSpin2.getSelectedItem().equals("Fahrenheit"))
                {
                    convertValue = (float) ((originalValue-273.15)*1.8+32);
                }
                if(tSpin1.getSelectedItem().equals("Kelvin") && tSpin2.getSelectedItem().equals("Kelvin"))
                {
                    convertValue = originalValue;
                }
                ett2.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ett1.setText(null);
                ett2.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ett1.getText().toString().equals(""))
                {
                    ett1.setText("");
                }
                else
                {
                    Clear = ett1.getText().toString();
                    Back = true;
                    ett1.setText(Clear.substring(0,Clear.length()-1));
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(temperature.this,frm2.class);
                startActivity(i);
            }
        });
    }
}