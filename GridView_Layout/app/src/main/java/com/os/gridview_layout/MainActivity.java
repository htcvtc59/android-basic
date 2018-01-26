package com.os.gridview_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String arr[] = {"Ipad","Iphone","new ipad","samsung",
            "Nokia","Sony","Macbook","Htc","Bphone","hkphone"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView selection = (TextView)findViewById(R.id.selection);
        GridView gridView = (GridView)findViewById(R.id.gridView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
          this,android.R.layout.simple_list_item_1,arr
        );
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selection.setText(arr[i]);
            }
        });




    }
}
