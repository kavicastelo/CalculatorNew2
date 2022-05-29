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
import android.widget.Toast;

public class length extends AppCompatActivity {

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
        setContentView(R.layout.activity_length);
        l1=findViewById(R.id.l1);
        l2=findViewById(R.id.l2);
        l3=findViewById(R.id.l3);
        l4=findViewById(R.id.l4);
        l5=findViewById(R.id.l5);
        l6=findViewById(R.id.l6);
        l7=findViewById(R.id.l7);
        l8=findViewById(R.id.l8);
        l9=findViewById(R.id.l9);
        l0=findViewById(R.id.l0);
        lp=findViewById(R.id.lpoint);

        ac=findViewById(R.id.btnLac);
        clear=findViewById(R.id.btnLclear);

        etl1=findViewById(R.id.ltxt1);
        etl2=findViewById(R.id.ltxt2);

        back=findViewById(R.id.btnLback);

        lSpin1=findViewById(R.id.lspin1);
        lSpin2=findViewById(R.id.lspin2);

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
        if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("mm"))
        {
            convertValue = originalValue;
        }
        else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("cm"))
        {
            convertValue = originalValue/10;
        }
        else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("m"))
        {
            convertValue = originalValue/1000;
        }
        else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("km"))
        {
            convertValue = originalValue/1000000;
        }
        else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("in"))
        {
            convertValue = (float) (originalValue*0.0393700787);
        }
        else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("feet"))
        {
            convertValue = (float) (originalValue*0.0032808399);
        }
        else if (lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("mm"))
        {
            convertValue = originalValue*10;
        }
        else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("cm"))
        {
            convertValue = originalValue;
        }
        else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("m"))
        {
            convertValue = originalValue/100;
        }
        else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("km"))
        {
            convertValue = originalValue/100000;
        }
        else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("in"))
        {
            convertValue = (float) (originalValue*0.393700787);
        }
        else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("feet"))
        {
            convertValue = (float) (originalValue*0.032808399);
        }
        else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("mm"))
        {
            convertValue = originalValue*1000;
        }
        else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("cm"))
        {
            convertValue = originalValue*100;
        }
        else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("m"))
        {
            convertValue = originalValue;
        }
        else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("km"))
        {
            convertValue = originalValue/1000;
        }
        else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("in"))
        {
            convertValue = (float) (originalValue*39.3700787);
        }
        else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("feet"))
        {
            convertValue = (float) (originalValue*3.2808399);
        }
        else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("mm"))
        {
            convertValue = originalValue*1000000;
        }
        else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("cm"))
        {
            convertValue = originalValue*100000;
        }
        else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("m"))
        {
            convertValue = originalValue*1000;
        }
        else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("km"))
        {
            convertValue = originalValue;
        }
        else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("in"))
        {
            convertValue = (float) (originalValue*39370.0787);
        }
        else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("feet"))
        {
            convertValue = (float) (originalValue*3280.8399);
        }
        else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("mm"))
        {
            convertValue = (float) (originalValue*25.4);
        }
        else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("cm"))
        {
            convertValue = (float) (originalValue*2.54);
        }
        else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("m"))
        {
            convertValue = (float) (originalValue*0.0254);
        }
        else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("km"))
        {
            convertValue = (float) (originalValue*0.0000254);
        }
        else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("in"))
        {
            convertValue = originalValue;
        }
        else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("feet"))
        {
            convertValue = (float) (originalValue*0.08333);
        }
        else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("mm"))
        {
            convertValue = (float) (originalValue*304.8);
        }
        else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("cm"))
        {
            convertValue = (float) (originalValue*30.48);
        }
        else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("m"))
        {
            convertValue = (float) (originalValue*0.3048);
        }
        else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("km"))
        {
            convertValue = (float) (originalValue*0.0003048);
        }
        else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("in"))
        {
            convertValue = originalValue*12;
        }
        else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("feet"))
        {
            convertValue = originalValue;
        }

        lSpin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                originalValue = Float.parseFloat(etl1.getText().toString());
                if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = originalValue/10;
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = originalValue/1000;
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = (float) (originalValue*0.000001);
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = (float) (originalValue*0.0393700787);
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*0.0032808399);
                }
                else if (lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = originalValue*10;
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = originalValue/100;
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = (float) (originalValue*0.00001);
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = (float) (originalValue*0.393700787);
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*0.032808399);
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = originalValue*1000;
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = originalValue*100;
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = originalValue/1000;
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = (float) (originalValue*39.3700787);
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*3.2808399);
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = originalValue*1000000;
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = originalValue*100000;
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = originalValue*1000;
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = (float) (originalValue*39370.0787);
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*3280.8399);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = (float) (originalValue*25.4);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = (float) (originalValue*2.54);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = (float) (originalValue*0.0254);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = (float) (originalValue*0.0000254);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*0.08333);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = (float) (originalValue*304.8);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = (float) (originalValue*30.48);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = (float) (originalValue*0.3048);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = (float) (originalValue*0.0003048);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = originalValue*12;
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("feet"))
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
                if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = originalValue/10;
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = originalValue/1000;
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = (float) (originalValue*0.000001);
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = (float) (originalValue*0.0393700787);
                }
                else if(lSpin1.getSelectedItem().equals("mm") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*0.0032808399);
                }
                else if (lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = originalValue*10;
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = originalValue/100;
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = (float) (originalValue*0.00001);
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = (float) (originalValue*0.393700787);
                }
                else if(lSpin1.getSelectedItem().equals("cm") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*0.032808399);
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = originalValue*1000;
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = originalValue*100;
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = originalValue/1000;
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = (float) (originalValue*39.3700787);
                }
                else if(lSpin1.getSelectedItem().equals("m") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*3.2808399);
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = originalValue*1000000;
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = originalValue*100000;
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = originalValue*1000;
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = (float) (originalValue*39370.0787);
                }
                else if(lSpin1.getSelectedItem().equals("km") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*3280.8399);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = (float) (originalValue*25.4);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = (float) (originalValue*2.54);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = (float) (originalValue*0.0254);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = (float) (originalValue*0.0000254);
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = originalValue;
                }
                else if(lSpin1.getSelectedItem().equals("in") && lSpin2.getSelectedItem().equals("feet"))
                {
                    convertValue = (float) (originalValue*0.08333);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("mm"))
                {
                    convertValue = (float) (originalValue*304.8);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("cm"))
                {
                    convertValue = (float) (originalValue*30.48);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("m"))
                {
                    convertValue = (float) (originalValue*0.3048);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("km"))
                {
                    convertValue = (float) (originalValue*0.0003048);
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("in"))
                {
                    convertValue = originalValue*12;
                }
                else if(lSpin1.getSelectedItem().equals("feet") && lSpin2.getSelectedItem().equals("feet"))
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
                    etl1.setText(Clear.substring(0, Clear.length()-1));
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(length.this,frm2.class);
                startActivity(i);
            }
        });
    }
}