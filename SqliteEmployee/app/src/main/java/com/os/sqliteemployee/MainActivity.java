package com.os.sqliteemployee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHandler db;
    Button button;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);

        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listview);
        button = (Button) findViewById(R.id.button);

        List<Employee> list = db.getAllEmployees();
        List<String> stringList = new ArrayList<>();
        for (Employee e:list) {
            stringList.add(e.getName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                Employee employee = new Employee();
                employee.setName(s);
                Log.v("aa",s);
                db.addEmployee(employee);

                List<Employee> list = db.getAllEmployees();
                List<String> stringList = new ArrayList<>();
                for (Employee e:list) {
                    stringList.add(e.getName());
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList);
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }


}
