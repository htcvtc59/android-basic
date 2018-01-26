package com.os.gesturescroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<String> list;
    ArrayAdapter arrayAdapter;
    int i;

    GestureDetector gestureDetector;
    int Ymin = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("list" + i);
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
        gestureDetector = new GestureDetector(this, new MyGesture());
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });

    }

    private class MyGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            scroll down
            if (e2.getY() - e1.getY() > Ymin) {
                Toast.makeText(MainActivity.this, "scroll down", Toast.LENGTH_SHORT).show();
                list.add("list" + i++);
                arrayAdapter.notifyDataSetChanged();
            }
//            scroll up
            if (e1.getY() - e2.getY() > Ymin) {
                Toast.makeText(MainActivity.this, "scroll up", Toast.LENGTH_SHORT).show();
//                list.add("list" + i++);
//                arrayAdapter.notifyDataSetChanged();
            }

            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }
}
