package com.example.calculatornew2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatornew2.ui.gallery.GalleryFragment;

import java.io.Closeable;

public class login extends AppCompatActivity {

    EditText uname, pwd;
    Button log, reset, Register;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        uname = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
        log = findViewById(R.id.login);
        reset = findViewById(R.id.reset);
        Register = findViewById(R.id.register);
        t1 =findViewById(R.id.T1);
        t2 =findViewById(R.id.T2);
        
        database myDB = new database(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //uname.setText("");
                //pwd.setText("");
                Intent i = new Intent(login.this, admin.class);
                startActivity(i);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment mFragment = null;
                mFragment = new GalleryFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, mFragment).commitNow();
                uname.setVisibility(View.GONE);
                pwd.setVisibility(View.GONE);
                log.setVisibility(View.GONE);
                reset.setVisibility(View.GONE);
                Register.setVisibility(View.GONE);
                t1.setVisibility(View.GONE);
                t2.setVisibility(View.GONE);

            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor login = myDB.getloginfromDB();
                if (login.getCount()==0)
                {
                    Toast.makeText(login.this, "no details available..", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while(login.moveToNext())
                    {
                        if(uname.getText().toString().equals(login.getString(1)))
                        {
                            if(pwd.getText().toString().equals(login.getString(2)))
                            {
                                Intent i = new Intent(com.example.calculatornew2.login.this,admin.class);
                                startActivity(i);
                                Toast.makeText(login.this, "Login Success..", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(login.this, "Incorrect Password..", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(login.this, "Incorrect Username..", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
    public class galleryfragmentRegi extends FragmentActivity
    {
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            if(savedInstanceState==null)
            {
                getSupportFragmentManager().beginTransaction().
                add(androidx.navigation.ui.R.id.container, new GalleryFragment()).commit();
            }
        }
    }
}