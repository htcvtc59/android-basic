package com.os.autocompletetextviewsingleandmutiple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoTextView;
    Button btnClick;
    String[] arrCity = {"Ha Noi", "Hai Phong", "HCM", "Tien Giang", "Tay Ninh", "Thanh Hoa"};
    MultiAutoCompleteTextView mutiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoTextView = (AutoCompleteTextView) findViewById(R.id.autoTextView);
        btnClick = (Button) findViewById(R.id.btnClick);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, arrCity);
        autoTextView.setAdapter(arrayAdapter);

        autoTextView.setThreshold(1);
        autoTextView.setDropDownHeight(400);

        mutiText = (MultiAutoCompleteTextView) findViewById(R.id.mutiText);
        mutiText.setAdapter(arrayAdapter);
        mutiText.setThreshold(1);
        mutiText.setDropDownHeight(400);
        mutiText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
