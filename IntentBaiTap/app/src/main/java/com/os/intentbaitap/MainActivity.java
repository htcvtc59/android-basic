package com.os.intentbaitap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrName;
    ImageView imgCauHoi, imgNhan;
    int REQUEST_CODE_IMAGE = 123;
    String tenhinhGoc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCauHoi = (ImageView) findViewById(R.id.imgCauHoi);
        imgNhan = (ImageView) findViewById(R.id.imgNhan);


        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrName = new ArrayList<>(Arrays.asList(mangTen));

        Collections.shuffle(arrName);

        tenhinhGoc = arrName.get(4);

        int idHinh = getResources().getIdentifier(tenhinhGoc, "mipmap", getPackageName());
        imgCauHoi.setImageResource(idHinh);
        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, ImageActivity.class), REQUEST_CODE_IMAGE);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null) {
            int idHinhNhan = getResources().getIdentifier(data.getStringExtra("tenHinhChon"), "mipmap", getPackageName());
            imgNhan.setImageResource(idHinhNhan);

            if(tenhinhGoc.equals(data.getStringExtra("tenHinhChon"))){
                Toast.makeText(this, "chinh xac", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "sai roi", Toast.LENGTH_SHORT).show();
            }
        }

        if(requestCode == REQUEST_CODE_IMAGE && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuReload){
            Collections.shuffle(arrName);
            tenhinhGoc = arrName.get(4);
            int idHinh = getResources().getIdentifier(tenhinhGoc, "mipmap", getPackageName());
            imgCauHoi.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }
}
