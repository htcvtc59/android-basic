package com.os.contactmanagerasm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class AddContactActivity extends AppCompatActivity {

    EditText edtName, edtPhone;
    Button btnAddContact;

    ImageView imgContact;
    Button btnaddCamera;

    final int REQUEST_CODE_CAMERA = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        edtName = (EditText) findViewById(R.id.edtName);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        btnAddContact = (Button) findViewById(R.id.btnAddContact);
        imgContact = (ImageView) findViewById(R.id.imgaddContact);
        btnaddCamera = (Button) findViewById(R.id.btnaddCamera);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgContact.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] image = byteArrayOutputStream.toByteArray();

                String name = edtName.getText().toString();
                String phone = edtPhone.getText().toString();
                if (name.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(AddContactActivity.this, "Enter name and phone", Toast.LENGTH_SHORT).show();
                } else {
                    MainActivity.database.InsertContact(name, phone, image);
                    Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnaddCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgContact.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
