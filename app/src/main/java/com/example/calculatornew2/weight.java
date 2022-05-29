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

public class weight extends AppCompatActivity {

    TextView w1, w2, w3, w4, w5, w6, w7, w8, w9, w0, wp;
    Button ac, clear;
    EditText etw1, etw2;
    ImageButton back;
    Spinner wSpin1, wSpin2;
    float originalValue, convertValue;
    String Clear;
    boolean Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        w1=findViewById(R.id.w1);
        w2=findViewById(R.id.w2);
        w3=findViewById(R.id.w3);
        w4=findViewById(R.id.w4);
        w5=findViewById(R.id.w5);
        w6=findViewById(R.id.w6);
        w7=findViewById(R.id.w7);
        w8=findViewById(R.id.w8);
        w9=findViewById(R.id.w9);
        w0=findViewById(R.id.w0);
        wp=findViewById(R.id.wpoint);

        ac=findViewById(R.id.btnWac);
        clear=findViewById(R.id.btnWclear);

        etw1=findViewById(R.id.wtxt1);
        etw2=findViewById(R.id.wtxt2);

        back=findViewById(R.id.btnWback);

        wSpin1=findViewById(R.id.wspin1);
        wSpin2=findViewById(R.id.wspin2);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        etw1.requestFocus();
        etw2.requestFocus();

        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"1");
            }
        });
        w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"2");
            }
        });
        w3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"3");
            }
        });
        w4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"4");
            }
        });
        w5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"5");
            }
        });
        w6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"6");
            }
        });
        w7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"7");
            }
        });
        w8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"8");
            }
        });
        w9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"9");
            }
        });
        w0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+"0");
            }
        });
        wp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(etw1.getText()+".");
            }
        });

        etw1.setText(String.valueOf(convertValue));
        originalValue = Float.parseFloat(etw1.getText().toString());
        if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("mg"))
        {
            convertValue = originalValue;
        }
        if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("g"))
        {
            convertValue = originalValue/1000;
        }
        if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("kg"))
        {
            convertValue = originalValue/1000000;
        }
        if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("lb"))
        {
            convertValue = (float) (originalValue/0.0000004535924);
        }
        if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("mg"))
        {
            convertValue = originalValue*1000;
        }
        if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("g"))
        {
            convertValue = originalValue;
        }
        if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("kg"))
        {
            convertValue = originalValue*1000000;
        }
        if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("lb"))
        {
            convertValue = (float) (originalValue/0.0004535924);
        }
        if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("mg"))
        {
            convertValue = originalValue*1000000;
        }
        if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("g"))
        {
            convertValue = originalValue*1000;
        }
        if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("g"))
        {
            convertValue = originalValue;
        }
        if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("lb"))
        {
            convertValue = (float) (originalValue/0.4535924);
        }
        if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("mg"))
        {
            convertValue = (float) (originalValue*0.0000004535924);
        }
        if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("g"))
        {
            convertValue = (float) (originalValue*0.0004535924);
        }
        if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("kg"))
        {
            convertValue = (float) (originalValue*0.4535924);
        }
        if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("mg"))
        {
            convertValue = originalValue;
        }

        wSpin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //etw1.setText(String.valueOf(convertValue));
                originalValue = Float.parseFloat(etw1.getText().toString());
                if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = originalValue;
                }
                if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = originalValue/1000;
                }
                if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("kg"))
                {
                    convertValue = originalValue/1000000;
                }
                if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("lb"))
                {
                    convertValue = (float) (originalValue/0.0000004535924);
                }
                if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = originalValue*1000;
                }
                if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = originalValue;
                }
                if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("kg"))
                {
                    convertValue = originalValue*1000000;
                }
                if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("lb"))
                {
                    convertValue = (float) (originalValue/0.0004535924);
                }
                if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = originalValue*1000000;
                }
                if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = originalValue*1000;
                }
                if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = originalValue;
                }
                if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("lb"))
                {
                    convertValue = (float) (originalValue/0.4535924);
                }
                if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = (float) (originalValue*0.0000004535924);
                }
                if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = (float) (originalValue*0.0004535924);
                }
                if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("kg"))
                {
                    convertValue = (float) (originalValue*0.4535924);
                }
                if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = originalValue;
                }
                etw2.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        wSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //etw1.setText(String.valueOf(convertValue));
                originalValue = Float.parseFloat(etw1.getText().toString());
                if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = originalValue;
                }
                if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = originalValue/1000;
                }
                if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("kg"))
                {
                    convertValue = originalValue/1000000;
                }
                if(wSpin1.getSelectedItem().equals("mg") && wSpin2.getSelectedItem().equals("lb"))
                {
                    convertValue = (float) (originalValue/0.0000004535924);
                }
                if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = originalValue*1000;
                }
                if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = originalValue;
                }
                if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("kg"))
                {
                    convertValue = originalValue*1000000;
                }
                if(wSpin1.getSelectedItem().equals("g") && wSpin2.getSelectedItem().equals("lb"))
                {
                    convertValue = (float) (originalValue/0.0004535924);
                }
                if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = originalValue*1000000;
                }
                if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = originalValue*1000;
                }
                if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = originalValue;
                }
                if(wSpin1.getSelectedItem().equals("kg") && wSpin2.getSelectedItem().equals("lb"))
                {
                    convertValue = (float) (originalValue/0.4535924);
                }
                if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = (float) (originalValue*0.0000004535924);
                }
                if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("g"))
                {
                    convertValue = (float) (originalValue*0.0004535924);
                }
                if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("kg"))
                {
                    convertValue = (float) (originalValue*0.4535924);
                }
                if(wSpin1.getSelectedItem().equals("lb") && wSpin2.getSelectedItem().equals("mg"))
                {
                    convertValue = originalValue;
                }
                etw2.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etw1.getText().toString().equals(""))
                {
                    etw1.setText("");
                }
                else
                {
                    Clear = etw1.getText().toString();
                    Back = true;
                    etw1.setText(Clear.substring(0,Clear.length()-1));
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etw1.setText(null);
                etw2.setText(null);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(weight.this,frm2.class);
                startActivity(i);
            }
        });
    }
}