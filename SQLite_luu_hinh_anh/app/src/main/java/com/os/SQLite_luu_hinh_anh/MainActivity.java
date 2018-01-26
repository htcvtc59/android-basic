package com.os.SQLite_luu_hinh_anh;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThemDovat;
    public static Database database;
    ListView listView;
    ArrayList<DoVat> doVatArrayList;
    DoVatAdapter doVatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThemDovat = (Button) findViewById(R.id.btnThemDoVat);
        listView = (ListView) findViewById(R.id.listview);


        database = new Database(this, "QuanLy.sqlite", null, 1);
        database.QueryData("create table if not exists DoVat(id integer primary key autoincrement," +
                " Ten varchar(150), Mota varchar(250), HinhAnh blob)");

        doVatArrayList = new ArrayList<>();
        doVatAdapter = new DoVatAdapter(this, R.layout.dong_do_vat, doVatArrayList);
        listView.setAdapter(doVatAdapter);

        Cursor cursor = database.GetData("select * from DoVat");

        while (cursor.moveToNext()) {
            doVatArrayList.add(new DoVat(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getBlob(3)
            ));
        }

        doVatAdapter.notifyDataSetChanged();


        btnThemDovat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ThemDoVatActivity.class));

            }
        });


    }
}
