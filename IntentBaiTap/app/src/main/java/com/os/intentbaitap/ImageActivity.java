package com.os.intentbaitap;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class ImageActivity extends Activity {

    TableLayout myTableImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        myTableImage = (TableLayout) findViewById(R.id.tableImage);

        int soDong = 4;
        int soCot = 2;

        Collections.shuffle(MainActivity.arrName);

        for (int i = 1; i <= soDong; i++) {
            TableRow tableRow = new TableRow(this);

            for (int j = 1; j <= soCot; j++) {
                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(200, 200);
                imageView.setLayoutParams(layoutParams);

                final int vitri = soCot * (i - 1) + j - 1;

                int idHinh = getResources().getIdentifier(MainActivity.arrName.get(vitri), "mipmap", getPackageName());
                imageView.setImageResource(idHinh);
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("tenHinhChon",MainActivity.arrName.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });

            }
            myTableImage.addView(tableRow);

        }

    }
}
