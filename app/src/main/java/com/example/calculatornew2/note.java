package com.example.calculatornew2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class note extends AppCompatActivity {

    Button save, view, clear;
    EditText savename, addnotetxt;
    ImageButton cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        databaseHandler myDB = new databaseHandler(this);

        save=findViewById(R.id.btnaddnote);
        view=findViewById(R.id.btnviewnote);
        clear=findViewById(R.id.btnclearnote);
        savename=findViewById(R.id.txtnotesave);
        addnotetxt=findViewById(R.id.txtaddnote);
        cancle=findViewById(R.id.btnclearnotesavingname);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!addnotetxt.getText().toString().equals("")&&!savename.getText().toString().equals(""))
                {
                    Cursor check = myDB.viewNoteDet();
                    boolean isAdded = myDB.saveNote(savename.getText().toString(),addnotetxt.getText().toString());
                    if(isAdded)
                    {
                        Toast.makeText(note.this, "Saved", Toast.LENGTH_SHORT).show();
                        savename.setText(null);
                        addnotetxt.setText(null);
                    }
                    else
                    {
                        Toast.makeText(note.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(note.this, "Missing Required information", Toast.LENGTH_SHORT).show();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnotetxt.setText(null);
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savename.setText(null);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(note.this,viewNotes.class);
                startActivity(i);
            }
        });
    }
}