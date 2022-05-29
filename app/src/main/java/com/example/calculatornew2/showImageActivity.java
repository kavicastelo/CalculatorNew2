package com.example.calculatornew2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class showImageActivity extends AppCompatActivity {

    private databaseHandler objectDatabaseHandler;
    private RecyclerView objectRecyclerView;
    private RVAdapter objectRvAdapter;

    private EditText row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        row = findViewById(R.id.txtdeleterow);

        try {
            objectRecyclerView = findViewById(R.id.imageRV);
            objectDatabaseHandler = new databaseHandler(this);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void getData(View view){
        Cursor get = objectDatabaseHandler.getImageName();
        if(get.getCount()!=0)
        {
            while (get.moveToNext())
            {
                if(get.getString(0).equals(""))
                {
                    objectRvAdapter = new RVAdapter(objectDatabaseHandler.getAllImagesData());
                    objectRecyclerView.setHasFixedSize(true);

                    objectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                    objectRecyclerView.setAdapter(objectRvAdapter);
                }
                else
                {
                    try {
                        objectRvAdapter = new RVAdapter(objectDatabaseHandler.getAllImagesData());
                        objectRecyclerView.setHasFixedSize(true);

                        objectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                        objectRecyclerView.setAdapter(objectRvAdapter);
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        else
        {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
    public void DeleteImage(View view)
    {
        if(!row.getText().toString().isEmpty())
        {
            boolean isDeleted = objectDatabaseHandler.deleteImage(row.getText().toString());
            if(isDeleted)
            {
                Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show();
                Snackbar.make(view,"Re-tap the load button to view result",Snackbar.LENGTH_SHORT).show();
                row.setText(null);
            }
            else
            {
                Toast.makeText(this, "not deleted", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Enter image name to delete", Toast.LENGTH_SHORT).show();
        }
    }
    public void DownloadImage(View view)
    {
        if(!row.getText().toString().equals(""))
        {
            boolean isDownload = objectDatabaseHandler.downloadImage(row.getText().toString());
            if(isDownload)
            {
                Toast.makeText(this, "Downloaded", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Download failed", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Enter image name to download", Toast.LENGTH_SHORT).show();
        }
    }
}