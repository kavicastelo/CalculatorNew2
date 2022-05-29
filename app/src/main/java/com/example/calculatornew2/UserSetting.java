package com.example.calculatornew2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.calculatornew2.ui.gallery.GalleryFragment;
import com.example.calculatornew2.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;

public class UserSetting extends AppCompatActivity {

    Button Nadd, Nclear, Cadd, Cclear, Uadd, Uclear, Padd, Pclear, add, clear;
    EditText CreatateNpin, CreateConNpin, cngOpin, cngNpin, cngConpin, Nfname, Nlname, Ncemail, Nnemail, Nnphone, cPass, nPass, ConPass;
    ImageButton Nconpin, Cconpin, conPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        Nadd = findViewById(R.id.btncanclepin);
        Nclear = findViewById(R.id.btnaddpin3);
        Cadd = findViewById(R.id.btnaddchnge);
        Cclear = findViewById(R.id.btnaddchnge2);
        Uadd = findViewById(R.id.btnupdate);
        Uclear = findViewById(R.id.btnupdateclear);
        Padd = findViewById(R.id.btnpasschange);
        Pclear = findViewById(R.id.btnpassclear);
        add = findViewById(R.id.btnsettingdone);
        clear = findViewById(R.id.btnsettingcancel);

        CreatateNpin = findViewById(R.id.newpass);
        CreateConNpin = findViewById(R.id.confirmpass);
        cngOpin = findViewById(R.id.allpass);
        cngNpin = findViewById(R.id.cngnewpass);
        cngConpin = findViewById(R.id.conchndnewpass);
        Nfname = findViewById(R.id.newfname);
        Nlname = findViewById(R.id.newlname);
        Ncemail = findViewById(R.id.currentemail);
        Nnemail = findViewById(R.id.newemail);
        Nnphone = findViewById(R.id.newphone);
        cPass = findViewById(R.id.cpassword);
        nPass = findViewById(R.id.npassword);
        ConPass = findViewById(R.id.connpassword);

        Nconpin = findViewById(R.id.viewNconpin);
        Cconpin = findViewById(R.id.viewCconpin);
        conPass = findViewById(R.id.viewconpass);

        database myDB = new database(this);

        Nadd.setOnClickListener(new View.OnClickListener() { //add new pin
            @Override
            public void onClick(View view) {
                if(CreatateNpin.getText().toString().equals(CreateConNpin.getText().toString()))
                {
                    boolean isPinAdded = myDB.createPin(CreatateNpin.getText().toString());
                    if(isPinAdded)
                    {
                        CreatateNpin.setText(null);
                        CreateConNpin.setText(null);
                        Toast.makeText(UserSetting.this, "New PIN set", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(UserSetting.this, "fail", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Snackbar.make(view,"PIN not match to Confirm PIN ",Snackbar.LENGTH_LONG).show();
                }

            }
        });
        Nclear.setOnClickListener(new View.OnClickListener() { //clear new pin
            @Override
            public void onClick(View view) {
                CreatateNpin.setText(null);
                CreateConNpin.setText(null);
            }
        });
        Cadd.setOnClickListener(new View.OnClickListener() { //change pin
            @Override
            public void onClick(View view) {
                Cursor check = myDB.viewPinDet();
                if(check.getCount()==0)
                {
                    Toast.makeText(UserSetting.this, "PIN not found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (check.moveToNext())
                    {
                        if(check.getString(1).equals(cngOpin.getText().toString()))
                        {
                            if(cngNpin.getText().toString().equals(cngConpin.getText().toString()))
                            {
                                    boolean isUpdate = myDB.changePin(check.getString(0),cngConpin.getText().toString());
                                    if(isUpdate)
                                    {
                                        Toast.makeText(UserSetting.this, "Success", Toast.LENGTH_SHORT).show();
                                        cngOpin.setText(null);
                                        cngNpin.setText(null);
                                        cngConpin.setText(null);
                                    }
                                    else
                                    {
                                        Toast.makeText(UserSetting.this, "Not Updated", Toast.LENGTH_SHORT).show();
                                    }
                            }
                            else
                            {
                                Toast.makeText(UserSetting.this, "PIN not match to confirm PIN", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(UserSetting.this, "Invalid Current PIN", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        Cclear.setOnClickListener(new View.OnClickListener() { //clear change pin
            @Override
            public void onClick(View view) {
                cngOpin.setText(null);
                cngNpin.setText(null);
                cngConpin.setText(null);
            }
        });
        Uadd.setOnClickListener(new View.OnClickListener() { //change user info
            @Override
            public void onClick(View view) {
                Cursor check = myDB.viewMembers();
                if(check.getCount()==0)
                {
                    Toast.makeText(UserSetting.this, "User not found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(Nfname.getText().toString().equals("")||Nlname.getText().toString().equals("")||
                            Nnemail.getText().toString().equals("")||Ncemail.getText().toString().equals("")||
                            Nnphone.getText().toString().equals(""))
                    {
                        Toast.makeText(UserSetting.this, "Required all information", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        while (check.moveToNext())
                        {
                            if(check.getString(3).equals(Ncemail.getText().toString()))
                            {
                                boolean isUpadate = myDB.updatePersoninfo(check.getString(0),Nfname.getText().toString(),
                                        Nlname.getText().toString(),Nnemail.getText().toString(),Nnphone.getText().toString());
                                if(isUpadate)
                                {
                                    Toast.makeText(UserSetting.this, "Success", Toast.LENGTH_SHORT).show();
                                    Nfname.setText(null);
                                    Nlname.setText(null);
                                    Nnemail.setText(null);
                                    Ncemail.setText(null);
                                    Nnphone.setText(null);
                                }
                                else
                                {
                                    Toast.makeText(UserSetting.this, "Not Updated", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(UserSetting.this, "Current Email not matched", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
        Uclear.setOnClickListener(new View.OnClickListener() { //clear user info
            @Override
            public void onClick(View view) {
                Nfname.setText(null);
                Nlname.setText(null);
                Ncemail.setText(null);
                Nnemail.setText(null);
                Nnphone.setText(null);
            }
        });
        Padd.setOnClickListener(new View.OnClickListener() { //change password
            @Override
            public void onClick(View view) {
                Cursor check = myDB.viewLogindet();
                if(check.getCount()==0)
                {
                    Toast.makeText(UserSetting.this, "Password not found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (check.moveToNext())
                    {
                        if(cPass.getText().toString().equals(check.getString(2)))
                        {
                            if(nPass.getText().toString().equals(ConPass.getText().toString()))
                            {
                                boolean isUpdate = myDB.updatePassword(check.getString(0),ConPass.getText().toString());
                                if(isUpdate)
                                {
                                    Toast.makeText(UserSetting.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(UserSetting.this, "Not Updated", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(UserSetting.this, "Check confirm password", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(UserSetting.this, "Incorrect current password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        Pclear.setOnClickListener(new View.OnClickListener() { //clear password input
            @Override
            public void onClick(View view) {
                cPass.setText(null);
                nPass.setText(null);
                ConPass.setText(null);
            }
        });
        add.setOnClickListener(new View.OnClickListener() { //apply all changes
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserSetting.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(UserSetting.this, "Saved apply changes", Toast.LENGTH_SHORT).show();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() { //clear all
            @Override
            public void onClick(View view) {
                CreatateNpin.setText(null);
                CreateConNpin.setText(null);
                cngOpin.setText(null);
                cngNpin.setText(null);
                cngConpin.setText(null);
                Nfname.setText(null);
                Nlname.setText(null);
                Ncemail.setText(null);
                Nnemail.setText(null);
                Nnphone.setText(null);
            }
        });
        Nconpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CreateConNpin.getTransformationMethod().equals(PasswordTransformationMethod.getInstance()))
                {
                    Nconpin.setImageResource(R.drawable.ic_hidepass);
                    CreateConNpin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    Nconpin.setImageResource(R.drawable.ic_viewpass);
                    CreateConNpin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        Cconpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cngConpin.getTransformationMethod().equals(PasswordTransformationMethod.getInstance()))
                {
                    Cconpin.setImageResource(R.drawable.ic_hidepass);
                    cngConpin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    Cconpin.setImageResource(R.drawable.ic_viewpass);
                    cngConpin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        conPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ConPass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance()))
                {
                    conPass.setImageResource(R.drawable.ic_hidepass);
                    ConPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    conPass.setImageResource(R.drawable.ic_viewpass);
                    ConPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}