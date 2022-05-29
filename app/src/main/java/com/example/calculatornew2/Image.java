package com.example.calculatornew2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Image extends AppCompatActivity {

    private EditText imageDetailsET;
    private ImageView objectImageView;

    private static final int PICK_IMAGE_REQUEST = 100;
    private Uri imageFilePath;

    private Bitmap imageToStore;
    databaseHandler objectDatabaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        try {
            imageDetailsET=findViewById(R.id.imageNameET);
            objectImageView=findViewById(R.id.imageIV);

            objectDatabaseHandler = new databaseHandler(this);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void chooseImage(View objectView){
        try {
            Intent objectIntent=new Intent();
            objectIntent.setType("image/*");

            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,PICK_IMAGE_REQUEST);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null)
            {
                imageFilePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilePath);

                objectImageView.setImageBitmap(imageToStore);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void storeImage(View view){
        try {
            if(!imageDetailsET.getText().toString().isEmpty() && objectImageView.getDrawable() != null && imageToStore != null)
            {
                objectDatabaseHandler.storeImages(new ModelClass(imageDetailsET.getText().toString(), imageToStore));
            }
            else
            {
                Toast.makeText(this, "please select image name and image", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void moveToShowActivity(View view){
        //startActivity(new Intent(this,showImageActivity.class));
        Intent i = new Intent(Image.this,showImageActivity.class);
        startActivity(i);
    }
}