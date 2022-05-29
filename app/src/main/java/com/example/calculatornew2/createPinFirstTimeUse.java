package com.example.calculatornew2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createPinFirstTimeUse extends AppCompatActivity {

    EditText pin, conpin;
    Button add, reset, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pin_first_time_use);
        pin=findViewById(R.id.createPin);
        conpin=findViewById(R.id.confirmPin);
        add=findViewById(R.id.btnCreatePin);
        reset=findViewById(R.id.btnResetPin);
        cancel=findViewById(R.id.btnCancelPin);

        database myDB = new database(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pin.getText().toString().equals("") && conpin.getText().toString().equals(""))
                {
                    Toast.makeText(createPinFirstTimeUse.this, "Missing required information", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!pin.getText().toString().equals(conpin.getText().toString()))
                    {
                        Toast.makeText(createPinFirstTimeUse.this, "PIN not match to Confirm Pin", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        boolean isPinAdded = myDB.createPin(pin.getText().toString());
                        if(isPinAdded)
                        {
                            pin.setText(null);
                            conpin.setText(null);
                            Toast.makeText(createPinFirstTimeUse.this, "PIN created!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(createPinFirstTimeUse.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pin.setText(null);
                conpin.setText(null);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(createPinFirstTimeUse.this, "Sorry not set to the PIN!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(createPinFirstTimeUse.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}