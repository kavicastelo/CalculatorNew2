package com.example.calculatornew2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class admin extends AppCompatActivity {

    Button view, loginview, pinview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        view = findViewById(R.id.btnview);
        loginview = findViewById(R.id.btnloginview);
        pinview = findViewById(R.id.btnpinview);

        database myDB = new database(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor respond = myDB.viewMembers();
                if(respond.getCount()==0) {
                    Toast.makeText(admin.this, "Nobody registered to this app yet..", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    StringBuffer sb = new StringBuffer();
                    while (respond.moveToNext())
                    {
                        sb.append("User ID :" + respond.getString(0)+"\n");
                        sb.append("Name :" + respond.getString(1)+" "+ respond.getString(2)+"\n");
                        sb.append("Email :" + respond.getString(3)+"\n");
                        sb.append("Phone no :" + respond.getString(4)+"\n");
                        sb.append("Birthday :" + respond.getString(5)+"\n");
                        sb.append("Gender :" + respond.getString(6)+"\n");
                        sb.append("========== END ==========\n");
                    }
                    showMembers("Registers", sb.toString());
                }
            }
        });
        loginview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor respond = myDB.viewLogindet();
                if(respond.getCount()==0)
                {
                    Toast.makeText(admin.this, "Nobody registered to this app yet..", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    StringBuffer sb = new StringBuffer();
                    while (respond.moveToNext())
                    {
                        sb.append("user ID : " + respond.getString(0)+"\n");
                        sb.append("username : " + respond.getString(1)+"\n");
                        sb.append("password :" + respond.getString(2)+"\n");
                        sb.append("========== end ==========\n");
                    }
                    showLoginDet("details",sb.toString());
                }

            }
        });
        pinview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor respond = myDB.viewPinDet();
                if(respond.getCount()==0)
                {
                    Toast.makeText(admin.this, "No PINS are set", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    StringBuffer sb = new StringBuffer();
                    while (respond.moveToNext())
                    {
                        sb.append("pin ID : " + respond.getString(0)+"\n");
                        sb.append("PIN : " +respond.getString(1)+"\n");
                        sb.append("=====================\n");
                    }
                    showPins("PIN list",sb.toString());
                }
            }
        });
    }
    public void showMembers(String title, String msg)
    {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setCancelable(true);
        ab.setTitle(title);
        ab.setMessage(msg);
        ab.show();
    }
    public void showLoginDet(String title, String msg)
    {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setCancelable(true);
        ab.setTitle(title);
        ab.setMessage(msg);
        ab.show();
    }
    public void showPins(String title, String msg)
    {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setCancelable(true);
        ab.setTitle(title);
        ab.setMessage(msg);
        ab.show();
    }
}