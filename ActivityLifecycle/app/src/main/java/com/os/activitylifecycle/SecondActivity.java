package com.os.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btnSecond;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecond = (Button) findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

        Log.d("first", "onCreate second");
        txtResult = (TextView) findViewById(R.id.txtResult);

        Intent intent = getIntent();
        String result = intent.getStringExtra("data");
        int dataint = intent.getIntExtra("dataint", 0);
        String[] dataarrs = intent.getStringArrayExtra("dataarr");

        HocSinh hocSinh = (HocSinh) intent.getSerializableExtra("obj");

        Bundle bundle = intent.getBundleExtra("bundlebig");
        if(bundle!=null){
            bundle.getString("bundle");
            bundle.getInt("bundleint", 0);
            bundle.getStringArray("bundlearr");
        }


        txtResult.setText(result + "\n" + dataint + "\n" + dataarrs.length + "\n" + hocSinh.getHoten() + "\n" + hocSinh.getNamsinh());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("first", "onStart second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("first", "onRestart second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("first", "onResume second");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("first", "onPause second");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("first", "onStop second");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("first", "onDestroy second");
    }
}
