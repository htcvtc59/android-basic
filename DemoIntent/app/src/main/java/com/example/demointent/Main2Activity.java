package com.example.demointent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main2Activity extends AppCompatActivity {

    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtShow = (TextView) findViewById(R.id.txtShow);

//        readData("data");

        readDataJson("test.json");
    }

    private void readData(String name) {

        InputStream in = null;
        try {
            in = this.openFileInput(name);
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = "";
            String content = "";
            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
            inputStreamReader.close();

//            content += this.getCacheDir().getPath();

            Toast.makeText(Main2Activity.this, content, Toast.LENGTH_LONG).show();

            txtShow.setText(content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void readDataJson(String file) {

        FileInputStream fileInputStream = null;
        try {
            String txtname = "";
            String gender = "";
            String course = "";
            String discount = "";

            fileInputStream = this.openFileInput(file);
            JsonReader reader = new JsonReader(new InputStreamReader(fileInputStream, "UTF-8"));

            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("name")) {
                    txtname = reader.nextString();
                } else if (name.equals("gender")) {
                    gender = reader.nextString();
                } else if (name.equals("course")) {
                    course = reader.nextString();
                } else if (name.equals("discount")) {
                    discount = reader.nextString();
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
            String content = txtname + gender + course + discount;

            Toast.makeText(this, content, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
