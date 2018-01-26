package com.example.demointent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnSave;
    Button btnView;
    Spinner spinner;
    Switch simpleSwitch;
    RadioGroup radioG;

    TextView txtName;
    String rad;
    String item;
    String discount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnView = (Button) findViewById(R.id.btnView);
        txtName = (TextView) findViewById(R.id.txtName);
        radioG = (RadioGroup) findViewById(R.id.radGroup);


        spinner = (Spinner) findViewById(R.id.course_spinner);

        simpleSwitch = (Switch) findViewById(R.id.switch_dis);

        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    discount = "yes";
                } else {
                    discount = "no";
                }
            }
        });

        spinner.setOnItemSelectedListener(this);
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("NodeJs");
        list.add("Python");
        list.add("Html");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        btnSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = "";
                content += txtName.getText() + " ";
                content += rad + " ";
                content += item + " ";
                content += discount + " ";
//                writeData("data", content);

                writeDataJson("test.json", txtName.getText().toString(), rad, item, discount);
            }
        });

        btnView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int checkedRadio = radioGroup.getCheckedRadioButtonId();

                if (checkedRadio == R.id.no_radio_button) {
                    rad = "FeMale";
                } else if (checkedRadio == R.id.yes_radio_button) {
                    rad = "Male";
                }

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void writeData(String name, String content) {
        FileOutputStream fos = null;
        try {
            fos = this.openFileOutput(name, Context.MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.flush();
            fos.close();
            Toast.makeText(MainActivity.this, "write success", Toast.LENGTH_LONG).show();
        } catch (Exception e) {

        }


    }

    private void writeDataJson(String file, String name, String gender, String course, String discount) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.openFileOutput(file, Context.MODE_PRIVATE);
            JsonWriter writer = new JsonWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            writer.beginObject();
            writer.name("name").value(name);
            writer.name("gender").value(gender);
            writer.name("course").value(course);
            writer.name("discount").value(discount);
            writer.endObject();
            writer.close();

            Toast.makeText(MainActivity.this, "write success", Toast.LENGTH_LONG).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
