package com.example.calculatornew2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;

import com.example.calculatornew2.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class database extends SQLiteOpenHelper {

    public static final String dbName = "hideCal";
    public static final String TBL = "userDet";
    public static final String lTBL = "loginDet";
    public static final String pinTBL = "pinDet";

    //columns for user info
    public static final String COL1 = "uID";
    public static final String COL2 = "uFName";
    public static final String COL3 = "uLName";
    public static final String COL4 = "uEmail";
    public static final String COL5 = "uPhone";
    public static final String COL6 = "uDob";
    public static final String COL7 = "uGender";
    //columns for login
    public static final String lCOL1 = "lID";
    public static final String lCOL2 = "uUsername";
    public static final String lCOL3 = "uPassword";
    //columns for pin
    public static final String pCOL1 = "pID";
    public static final String pCOL2 = "pin";


    public database(@Nullable Context context) {
        super(context, dbName, null, 1);
        SQLiteDatabase db =this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TBL+ "(uID INTEGER PRIMARY KEY AUTOINCREMENT, uFName TEXT, uLName TEXT, " +
                "uEmail TEXT, uPhone REAL, uDob TEXT, uGender TEXT)");
        db.execSQL("CREATE TABLE "+lTBL+"(lID INTEGER PRIMARY KEY AUTOINCREMENT, uUsername TEXT, uPassword TEXT)");
        db.execSQL("CREATE TABLE "+pinTBL+"(pID INTEGER PRIMARY KEY AUTOINCREMENT, pin TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TBL);
        db.execSQL("DROP TABLE iF EXISTS "+lTBL);
        db.execSQL("DROP TABLE IF EXISTS "+pinTBL);
        onCreate(db);
    }
    //############################ Register page functions #############################
    public boolean AddMember(String uFName, String uLName, String uEmail, String uPhone, String uDob, String uGender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contval = new ContentValues();
        contval.put(COL2,uFName);
        contval.put(COL3,uLName);
        contval.put(COL4,uEmail);
        contval.put(COL5,uPhone);
        contval.put(COL6,uDob);
        contval.put(COL7,uGender);
        long result = db.insert(TBL,null, contval);

        return result != -1;
    }
    //############################ Register page functions #############################

    //############################ Login page functions #############################
    public boolean addLoginDet(String uUsername, String uPassword)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues login = new ContentValues();
        login.put(lCOL2,uUsername);
        login.put(lCOL3,uPassword);
        long result = db.insert(lTBL,null,login);

        return result != -1;
    }

    public Cursor getloginfromDB()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor username = db.rawQuery("SELECT * FROM " +lTBL,null);
        return username;
    }
    //############################ Login page functions #############################

    //############################ Admin page functions #############################
    public Cursor viewMembers()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor request = db.rawQuery("SELECT * FROM "+TBL, null);
        return request;
    }
    public Cursor viewLogindet()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor requestlogin = db.rawQuery("SELECT * FROM "+lTBL, null);
        return requestlogin;
    }
    //############################ Admin page functions #############################

    //############################ settings page functions #############################
    public Cursor callName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor requestName = db.rawQuery("SELECT * FROM "+TBL, null);
        return requestName;
    }
    public boolean createPin(String pin)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues pinVal = new ContentValues();
        pinVal.put(pCOL2,pin);
        long result = db.insert(pinTBL,null,pinVal);
        return result != -1;
    }
    public Cursor viewPinDet()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor requestpin = db.rawQuery("SELECT * FROM "+pinTBL,null);
        return requestpin;
    }
    public boolean changePin(String id, String Pin)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updatePin = new ContentValues();
        updatePin.put(pCOL2,Pin);

        db.update(pinTBL, updatePin,"pID=?", new String[]{id});
        return true;
    }
    public boolean updatePersoninfo(String id, String fname, String lname, String email, String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updatePerson = new ContentValues();
        updatePerson.put(COL2,fname);
        updatePerson.put(COL3,lname);
        updatePerson.put(COL4,email);
        updatePerson.put(COL5,phone);

        db.update(TBL, updatePerson,"uID=?", new String[]{id});
        return true;
    }
    public boolean updatePassword(String id, String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updatePass = new ContentValues();
        updatePass.put(lCOL3,pass);

        db.update(lTBL, updatePass, "lID=?", new String[]{id});
        return true;
    }
    //############################ settings page functions #############################

    //############################ image functions #############################
    //############################ image functions #############################
}
