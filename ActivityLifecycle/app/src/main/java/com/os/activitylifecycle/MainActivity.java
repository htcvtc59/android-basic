package com.os.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Button btnFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = (Button) findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", "Content");
                intent.putExtra("dataint", 2018);
                String[] arrayCourse = {"Android", "Ios", "PHP"};
                intent.putExtra("dataarr", arrayCourse);
                HocSinh hocSinh = new HocSinh("Tron",97);
                intent.putExtra("obj", hocSinh);

                Bundle bundle = new Bundle();
                bundle.putString("bundle","Bundle");
                bundle.putInt("bundleint",12345);
                bundle.putStringArray("bundlearr",arrayCourse);
                bundle.putSerializable("bundleobj",hocSinh);

                intent.putExtra("bundlebig",bundle);

                startActivity(intent);
            }
        });

        Log.d("first", "onCreate Main");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("first", "onStart Main");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("first", "onRestart Main");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("first", "onResume Main");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("first", "onPause Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("first", "onStop Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("first", "onDestroy Main");
    }
}
