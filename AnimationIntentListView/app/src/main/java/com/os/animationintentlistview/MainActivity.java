package com.os.animationintentlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnFirst;

    ListView listView;
    ArrayAdapter arrayAdapter;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = (Button) findViewById(R.id.btnFirst);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
            }
        });

        listView = (ListView) findViewById(R.id.listview);
        list = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            list.add("iaaaaaaaaaaaaaaaaaaaaa"+i);
        }
        arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_listscale);
        listView.startAnimation(animation);
        listView.setAdapter(arrayAdapter);


    }
}
