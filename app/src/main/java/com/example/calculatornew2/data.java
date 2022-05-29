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

public class data extends AppCompatActivity {

    TextView d1, d2, d3, d4, d5, d6, d7, d8, d9, d0, dp;
    Button ac, clear;
    EditText etd1, etd2;
    ImageButton back;
    Spinner dSpin1, dSpin2;
    float originalValue, convertValue;
    String Clear;
    boolean Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        d1=findViewById(R.id.d1);
        d2=findViewById(R.id.d2);
        d3=findViewById(R.id.d3);
        d4=findViewById(R.id.d4);
        d5=findViewById(R.id.d5);
        d6=findViewById(R.id.d6);
        d7=findViewById(R.id.d7);
        d8=findViewById(R.id.d8);
        d9=findViewById(R.id.d9);
        d0=findViewById(R.id.d0);
        dp=findViewById(R.id.dpoint);

        ac=findViewById(R.id.btnDac);
        clear=findViewById(R.id.btnDclear);

        etd1=findViewById(R.id.dtxt1);
        etd2=findViewById(R.id.dtxt2);

        back=findViewById(R.id.btnDback);

        dSpin1=findViewById(R.id.dspin1);
        dSpin2=findViewById(R.id.dspin2);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        etd1.requestFocus();
        etd2.requestFocus();

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"1");
            }
        });
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"2");
            }
        });
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"3");
            }
        });
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"4");
            }
        });
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"5");
            }
        });
        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"6");
            }
        });
        d7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"7");
            }
        });
        d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"8");
            }
        });
        d9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"9");
            }
        });
        d0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+"0");
            }
        });
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(etd1.getText()+".");
            }
        });

        etd1.setText(String.valueOf(convertValue));
        originalValue = Float.parseFloat(etd1.getText().toString());
        if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("bit"))
        {
            convertValue = originalValue;
        }
        if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("Byte"))
        {
            convertValue = originalValue*8;
        }
        if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("KB"))
        {
            convertValue = originalValue*8*1024;
        }
        if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("MB"))
        {
            convertValue = originalValue*8*1024*1024;
        }
        if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("GB"))
        {
            convertValue = originalValue*8*1024*1024*1024;
        }
        if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("TB"))
        {
            convertValue = originalValue*8*1024*1024*1024*1024;
        }
        if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("bit"))
        {
            convertValue = originalValue/8;
        }
        if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("Byte"))
        {
            convertValue = originalValue;
        }
        if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("KB"))
        {
            convertValue = originalValue*1024;
        }
        if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("MB"))
        {
            convertValue = originalValue*1024*1024;
        }
        if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("GB"))
        {
            convertValue = originalValue*1024*1024*1024;
        }
        if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("TB"))
        {
            convertValue = originalValue*1024*1024*1024*1024;
        }
        if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("bit"))
        {
            convertValue = originalValue/1024/8;
        }
        if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("Byte"))
        {
            convertValue = originalValue/1024;
        }
        if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("KB"))
        {
            convertValue = originalValue;
        }
        if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("MB"))
        {
            convertValue = originalValue*1024;
        }
        if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("GB"))
        {
            convertValue = originalValue*1024*1024;
        }
        if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("TB"))
        {
            convertValue = originalValue*1024*1024*1024;
        }
        if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("bit"))
        {
            convertValue = originalValue/1024/1024/8;
        }
        if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("Byte"))
        {
            convertValue = originalValue/1024/1024;
        }
        if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("KB"))
        {
            convertValue = originalValue/1024;
        }
        if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("MB"))
        {
            convertValue = originalValue;
        }
        if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("GB"))
        {
            convertValue = originalValue*1024;
        }
        if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("TB"))
        {
            convertValue = originalValue*1024*1024;
        }
        if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("bit"))
        {
            convertValue = originalValue/1024/1024/1024/8;
        }
        if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("Byte"))
        {
            convertValue = originalValue/1024/1024/1024;
        }
        if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("KB"))
        {
            convertValue = originalValue/1024/1024;
        }
        if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("MB"))
        {
            convertValue = originalValue/1024;
        }
        if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("GB"))
        {
            convertValue = originalValue;
        }
        if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("TB"))
        {
            convertValue = originalValue*1024;
        }
        if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("bit"))
        {
            convertValue = originalValue/1024/1024/1024/1024/8;
        }
        if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("Byte"))
        {
            convertValue = originalValue/1024/1024/1024/1024;
        }
        if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("KB"))
        {
            convertValue = originalValue/1024/1024/1024;
        }
        if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("MB"))
        {
            convertValue = originalValue/1024/1024;
        }
        if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("GB"))
        {
            convertValue = originalValue/1024;
        }
        if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("TB"))
        {
            convertValue = originalValue;
        }

        dSpin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                originalValue = Float.parseFloat(etd1.getText().toString());
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue*8;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue*8*1024;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue*8*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue*8*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*8*1024*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/8;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue*1024;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*1024*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/1024/8;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue/1024;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue*1024;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/1024/1024/8;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue/1024;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue*1024;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/1024/1024/1024/8;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue/1024/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue/1024;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/1024/1024/1024/1024/8;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue/1024/1024/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue/1024/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue/1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue;
                }
                etd2.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                originalValue = Float.parseFloat(etd1.getText().toString());
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue*8;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue*8*1024;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue*8*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue*8*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("bit") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*8*1024*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/8;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue*1024;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("Byte") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*1024*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/1024/8;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue/1024;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue*1024;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("KB") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*1024*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/1024/1024/8;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue/1024;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue*1024;
                }
                if(dSpin1.getSelectedItem().equals("MB") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*1024*1024;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/1024/1024/1024/8;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue/1024/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue/1024;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue;
                }
                if(dSpin1.getSelectedItem().equals("GB") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue*1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("bit"))
                {
                    convertValue = originalValue/1024/1024/1024/1024/8;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("Byte"))
                {
                    convertValue = originalValue/1024/1024/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("KB"))
                {
                    convertValue = originalValue/1024/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("MB"))
                {
                    convertValue = originalValue/1024/1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("GB"))
                {
                    convertValue = originalValue/1024;
                }
                if(dSpin1.getSelectedItem().equals("TB") && dSpin2.getSelectedItem().equals("TB"))
                {
                    convertValue = originalValue;
                }
                etd2.setText(String.valueOf(convertValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd1.setText(null);
                etd2.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etd1.getText().toString().equals(""))
                {
                    etd1.setText("");
                }
                else
                {
                    Clear = etd1.getText().toString();
                    Back = true;
                    etd1.setText(Clear.substring(0,Clear.length()-1));
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(data.this,frm2.class);
                startActivity(i);
            }
        });
    }
}