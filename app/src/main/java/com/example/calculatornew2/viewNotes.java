package com.example.calculatornew2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class viewNotes extends AppCompatActivity {

    Spinner chooseNote;
    EditText viewer;
    ImageButton delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);

        databaseHandler myDB = new databaseHandler(this);

        chooseNote=findViewById(R.id.spnviewnote);
        viewer=findViewById(R.id.txtviewnote);
        delete=findViewById(R.id.btndeletenote);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        viewer.requestFocus();

        ArrayList<String> allIDs = myDB.getNoteName();
        ArrayAdapter<String> IDAdapter = new ArrayAdapter<String>(viewNotes.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,allIDs);
        chooseNote.setAdapter(IDAdapter);

        chooseNote.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor getName = myDB.getNotesToSpinner(chooseNote.getSelectedItem().toString());
                if(getName.getCount()==0)
                {
                    Toast.makeText(viewNotes.this, "No text files available", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (getName.moveToNext())
                    {
                        viewer.setText(getName.getString(1));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDelete = myDB.deleteNote(chooseNote.getSelectedItem().toString());
                if(isDelete)
                {
                    Toast.makeText(viewNotes.this, "Deleted", Toast.LENGTH_SHORT).show();
                    ArrayList<String> allIDs = myDB.getNoteName();
                    ArrayAdapter<String> IDAdapter = new ArrayAdapter<String>(viewNotes.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,allIDs);
                    chooseNote.setAdapter(IDAdapter);
                }
                else
                {
                    Toast.makeText(viewNotes.this, "Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}