package com.example.listviewad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewTraiCay;
    ArrayList<TraiCay> arrayListTraiCay;
    TraiCayAdapter traiCayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTraiCay = (ListView)findViewById(R.id.listviewTraiCay);

        arrayListTraiCay = new ArrayList<>();

        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));
        arrayListTraiCay.add(new TraiCay("poke1","poke1 ngon",R.mipmap.poke1));
        arrayListTraiCay.add(new TraiCay("poke2","poke2 ngon",R.mipmap.poke2));
        arrayListTraiCay.add(new TraiCay("poke3","poke3 ngon",R.mipmap.poke3));


        traiCayAdapter = new TraiCayAdapter(this,R.layout.dong_trai_cay,arrayListTraiCay);

        listViewTraiCay.setAdapter(traiCayAdapter);


    }
}
