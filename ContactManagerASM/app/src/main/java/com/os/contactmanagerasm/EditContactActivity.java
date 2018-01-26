package com.os.contactmanagerasm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class EditContactActivity extends AppCompatActivity {

    EditText edtEditName, edtEditPhone;
    Button btnEditContact;

    ImageView imgeditContact;
    Button btneditCamera;

    final int REQUEST_CODE_CAMERA = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        edtEditName = (EditText) findViewById(R.id.edtEditName);
        edtEditPhone = (EditText) findViewById(R.id.edtEditPhone);
        btnEditContact = (Button) findViewById(R.id.btnEditContact);

        imgeditContact = (ImageView) findViewById(R.id.imgeditContact);
        btneditCamera = (Button) findViewById(R.id.btneditCamera);

        Intent intent = getIntent();
        final Contact contact = (Contact) intent.getSerializableExtra("contact");

        edtEditName.setText(contact.getName());
        edtEditPhone.setText(contact.getPhone());

        final byte[] imgC = contact.getImgcontact();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imgC, 0, imgC.length);
        imgeditContact.setImageBitmap(bitmap);

        btnEditContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtEditName.getText().toString();
                String phone = edtEditPhone.getText().toString();

                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgeditContact.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] image = byteArrayOutputStream.toByteArray();

                if (name.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(EditContactActivity.this, "Enter name and phone", Toast.LENGTH_SHORT).show();
                } else {
                    MainActivity.database.UpdateContact(name, phone, image, contact.getId());

                    Intent intent = new Intent(EditContactActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });


        btneditCamera.setOnClickListener(new View.OnClickListener() {
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
            imgeditContact.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
