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

public class bmi extends AppCompatActivity {

    EditText etb1, etb2, etbout;
    TextView b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bp;
    Button ac, clear, go;
    ImageButton back;
    Spinner bSpin1, bSpin2;
    float weightValue, heightValue, convertValue;
    String Clear;
    boolean Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        ac=findViewById(R.id.btnBac);
        clear=findViewById(R.id.btnBclear);
        go=findViewById(R.id.btnBok);

        etb1=findViewById(R.id.btxt1);
        etb2=findViewById(R.id.btxt2);
        etbout=findViewById(R.id.txtbmiiview);

        back=findViewById(R.id.btnBback);

        bSpin1=findViewById(R.id.bspin1);
        bSpin2=findViewById(R.id.bspin2);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        etb1.requestFocus();
        etb2.requestFocus();
        etbout.requestFocus();

        etb1.setText(String.valueOf(convertValue));
        etb2.setText(String.valueOf(convertValue));
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etb1.getText().toString().equals(""))
                {
                    etb1.setText("");
                }
                else {
                    weightValue = Float.parseFloat(etb1.getText().toString());
                    heightValue = Float.parseFloat(etb2.getText().toString());

                    if (bSpin1.getSelectedItem().equals("kg") && bSpin2.getSelectedItem().equals("m")) {
                        convertValue = weightValue / (heightValue * heightValue);
                    }
                    if (bSpin1.getSelectedItem().equals("lb") && bSpin2.getSelectedItem().equals("m")) {
                        convertValue = (float) ((weightValue * 0.45359237) / (heightValue * heightValue));
                    }
                    if (bSpin1.getSelectedItem().equals("kg") && bSpin2.getSelectedItem().equals("cm")) {
                        convertValue = weightValue / ((heightValue / 100) * (heightValue / 100));
                    }
                    if (bSpin1.getSelectedItem().equals("lb") && bSpin2.getSelectedItem().equals("cm")) {
                        convertValue = (float) ((weightValue * 0.45359237) / ((heightValue / 100) * (heightValue / 100)));
                    }
                    if (bSpin1.getSelectedItem().equals("kg") && bSpin2.getSelectedItem().equals("feet")) {
                        convertValue = (float) (weightValue / ((heightValue * 0.3048) * (heightValue * 0.3048)));
                    }
                    if (bSpin1.getSelectedItem().equals("lb") && bSpin2.getSelectedItem().equals("feet")) {
                        convertValue = (float) ((weightValue * 0.45359237) / ((heightValue * 0.3048) * (heightValue * 0.3048)));
                    }
                    etbout.setText(String.valueOf(convertValue));
                }
            }
        });
        bSpin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                weightValue = Float.parseFloat(etb1.getText().toString());
                heightValue = Float.parseFloat(etb2.getText().toString());
                if(bSpin1.getSelectedItem().equals("kg") && bSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = weightValue/(heightValue*heightValue);
                }
                if(bSpin1.getSelectedItem().equals("lb") && bSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = (float) ((weightValue*0.45359237)/(heightValue*heightValue));
                }
                if(bSpin1.getSelectedItem().equals("kg") && bSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = weightValue/((heightValue/100)*(heightValue/100));
                }
                if(bSpin1.getSelectedItem().equals("lb") && bSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = (float) ((weightValue*0.45359237)/((heightValue/100)*(heightValue/100)));
                }
                if(bSpin1.getSelectedItem().equals("kg") && bSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (weightValue/((heightValue*0.3048)*(heightValue*0.3048)));
                }
                if(bSpin1.getSelectedItem().equals("lb") && bSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) ((weightValue*0.45359237)/((heightValue*0.3048)*(heightValue*0.3048)));
                }
                etbout.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        bSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                weightValue = Float.parseFloat(etb1.getText().toString());
                heightValue = Float.parseFloat(etb2.getText().toString());
                if(bSpin1.getSelectedItem().equals("kg") && bSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = weightValue/(heightValue*heightValue);
                }
                if(bSpin1.getSelectedItem().equals("lb") && bSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = (float) ((weightValue*0.45359237)/(heightValue*heightValue));
                }
                if(bSpin1.getSelectedItem().equals("kg") && bSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = weightValue/((heightValue/100)*(heightValue/100));
                }
                if(bSpin1.getSelectedItem().equals("lb") && bSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = (float) ((weightValue*0.45359237)/((heightValue/100)*(heightValue/100)));
                }
                if(bSpin1.getSelectedItem().equals("kg") && bSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (weightValue/((heightValue*0.3048)*(heightValue*0.3048)));
                }
                if(bSpin1.getSelectedItem().equals("lb") && bSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) ((weightValue*0.45359237)/((heightValue*0.3048)*(heightValue*0.3048)));
                }
                etbout.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etbout.getText().toString().equals("")) {
                    etbout.setText("");
                } else {
                    Clear = etbout.getText().toString();
                    Back = true;
                    etbout.setText(Clear.substring(0, Clear.length() - 1));
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etb1.setText(null);
                etb2.setText(null);
                etbout.setText(null);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(bmi.this, frm2.class);
                startActivity(i);
            }
        });
    }
}