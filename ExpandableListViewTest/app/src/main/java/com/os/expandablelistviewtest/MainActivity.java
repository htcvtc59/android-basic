package com.os.expandablelistviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> list;
    HashMap<String, List<String>> hashMap;
    CustomExpanListView customExpanListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        customExpanListView = new CustomExpanListView(
          MainActivity.this,list,hashMap
        );
        expandableListView.setAdapter(customExpanListView);

        Click_group();
        Click_child();
        Close_group();
        Open_group();

    }

    private void Open_group() {
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                Toast.makeText(MainActivity.this, list.get(i), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void Close_group() {
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                Toast.makeText(MainActivity.this, list.get(i), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void Click_child() {
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(MainActivity.this, hashMap.get(list.get(i)).get(i1), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    private void Click_group() {
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, list.get(i), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void addControl() {
        expandableListView = (ExpandableListView) findViewById(R.id.expand_activities_listView);
        list = new ArrayList<>();
        hashMap = new HashMap<>();

        list.add("Phim thang 11");
        list.add("Phim thang 10");
        list.add("Phim thang 12");

        List<String> stringList11 = new ArrayList<>();
        stringList11.add("The light11");
        stringList11.add("The light11");
        stringList11.add("The light11");
        stringList11.add("The light11");

        List<String> stringList10 = new ArrayList<>();
        stringList10.add("The light10");
        stringList10.add("The light10");
        stringList10.add("The light10");
        stringList10.add("The light10");

        List<String> stringList12 = new ArrayList<>();
        stringList12.add("The light12");
        stringList12.add("The light12");
        stringList12.add("The light12");
        stringList12.add("The light12");

        hashMap.put(list.get(0), stringList11);
        hashMap.put(list.get(1), stringList10);
        hashMap.put(list.get(2), stringList12);


    }
}
