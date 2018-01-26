package com.example.gridviewad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<HinhAnh> arrayList;
    HinhAnhAdapter hinhAnhAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridview);
        arrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            arrayList.add(new HinhAnh("a",R.drawable.ic_launcher_background));
        }

        hinhAnhAdapter = new HinhAnhAdapter(this,R.layout.dong_hinh_anh,arrayList);

        gridView.setAdapter(hinhAnhAdapter);
        gridView.setNumColumns(4);
        gridView.setVerticalSpacing(5);
        gridView.setHorizontalSpacing(5);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("a",arrayList.get(i).toString());
            }
        });


    }
}
