package com.example.calculatornew2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class databaseHandler extends SQLiteOpenHelper {

    Context context;

    private static final String DATABASE_NAME="mydb.db";
    private static final int DATABASE_VERSION=1;

    private static final String createTableQuery="create table imageInfo (imageName TEXT " +", image BLOB)";
    private static final String notesTable="create table noteInfo (noteName TEXT " +", note TEXT)";

    private static final String nCOL1 = "noteName";
    private static final String nCOL2 = "note";

    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[]  imageInBytes;

    public databaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(createTableQuery);
            db.execSQL(notesTable);
            //Toast.makeText(context, "Table created successfully", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //################################################ image #####################################################
    public void storeImages(ModelClass objectModelClass){
        SQLiteDatabase objectSQLiteDatabase = this.getWritableDatabase();
        Bitmap imageToStoreBitmap = objectModelClass.getImage();

        objectByteArrayOutputStream=new ByteArrayOutputStream();
        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG,100,objectByteArrayOutputStream);

        imageInBytes = objectByteArrayOutputStream.toByteArray();

        ContentValues objectContentValues = new ContentValues();
        objectContentValues.put("imageName",objectModelClass.getImageName());
        objectContentValues.put("image",imageInBytes);
        long checkIfQueryRuns = objectSQLiteDatabase.insert("imageInfo",null,objectContentValues);
        if(checkIfQueryRuns!=-1)
        {
            Toast.makeText(context, "Image Saved", Toast.LENGTH_SHORT).show();
            objectSQLiteDatabase.close();
        }
        else
        {
            Toast.makeText(context, "Image not Saved.\n try again", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList <ModelClass> getAllImagesData()
    {
        try {
            SQLiteDatabase objectSqLiteDatabase = this.getReadableDatabase();
            ArrayList<ModelClass> objectModelClassArrayList = new ArrayList<>();
            Cursor objectCursor = objectSqLiteDatabase.rawQuery("select * from imageInfo ",null);
            if (objectCursor.getCount()!=0)
            {
                while (objectCursor.moveToNext())
                {
                    String nameOfImage = objectCursor.getString(0);
                    byte[] imageBytes = objectCursor.getBlob(1);

                    Bitmap objectBitmap = BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                    objectModelClassArrayList.add(new ModelClass(nameOfImage,objectBitmap));
                }
                return objectModelClassArrayList;
            }
            else
            {
                Toast.makeText(context, "no data available in database", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }
    public boolean deleteImage(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("imageInfo","imageName=?",new String[]{name});
        return true;
    }
    public boolean downloadImage(String filename)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM imageInfo ",null);
            if(cursor.getCount()!=0)
            {
                while (cursor.moveToNext())
                {
                    String path = cursor.getString(1);
                    //String path = "https://longwoodgardens.org/sites/default/files/highlight_images/76758.jpg";

                    //byte[] val = cursor.getBlob(1);
                    //Bitmap bmp = BitmapFactory.decodeByteArray(val,0,val.length);

                    URL u = new URL(path);
                    HttpsURLConnection c = (HttpsURLConnection) u.openConnection();
                    c.setRequestMethod("GET");
                    c.setDoOutput(true);
                    c.connect();

                    String PATH = "/data/Calculator V1.0"
                    //Environment.getExternalStorageDirectory()
                            //+"/download/"
                            +"/";

                    Log.v("long_tag","PATH:" +PATH);
                    File file = new File(PATH);
                    file.mkdirs();
                    File outputFile = new File(file,filename);

                    FileOutputStream f = new FileOutputStream(outputFile);
                    InputStream in = c.getInputStream();
                    Log.v("log_tag"," InputStream consist of : "+in.read());
                    byte[] buffer = new byte[1024];
                    int len1 = 0;
                    while ((len1 = in.read(buffer)) > 0) {
                        //System.out.println("Reading byte : "+in.read(buffer));
                        f.write(buffer, 0, len1);
                    }
                    Toast.makeText(context, "Download Completed Successfully @ "+PATH, Toast.LENGTH_LONG).show();
                    f.close();
                }
            }
            else
            {
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    public Cursor getImageName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM imageInfo ",null);
        return cursor;
    }
    //################################################ image #####################################################

    //################################################ note #####################################################
    public boolean saveNote(String noteName, String note)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues store = new ContentValues();
        store.put(nCOL1,noteName);
        store.put(nCOL2,note);
        long result = db.insert("noteInfo",null,store);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getNotesToSpinner(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor getnotes = db.rawQuery("SELECT * FROM " +"noteInfo"+" WHERE noteName="+name,null);
        return getnotes;
    }
    public ArrayList<String> getNoteName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> list = new ArrayList<String>();
        String strSQL = "SELECT noteName FROM "+"noteInfo";
        Cursor cursor = db.rawQuery(strSQL,null);
        if(cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                @SuppressLint("Range") String note = cursor.getString(cursor.getColumnIndex("noteName"));
                list.add(note);
            }
        }
        return list;
    }
    public Cursor viewNoteDet()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor get = db.rawQuery("SELECT * FROM "+"noteInfo",null);
        return get;
    }
    public boolean deleteNote(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("noteInfo","noteName=?",new String[]{name});
        return true;
    }
    //################################################ note #####################################################
}
