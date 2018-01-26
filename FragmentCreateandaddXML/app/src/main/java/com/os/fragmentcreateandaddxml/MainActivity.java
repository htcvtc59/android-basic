package com.os.fragmentcreateandaddxml;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnfragmentA, btnfragmentB, btntextchange;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfragmentA = (Button) findViewById(R.id.btnfragmentA);
        btnfragmentB = (Button) findViewById(R.id.btnfragmentB);

        btntextchange = (Button) findViewById(R.id.btntextchange);
        textView = (TextView) findViewById(R.id.textView);

        btntextchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentById(R.id.fragmentA);
                fragmentA.GanNoiDung("Activity");
            }
        });


        //        Fragment Add by code


    }

    public void addFragment(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.btnfragmentA:
                fragment = new FragmentA();
                break;
            case R.id.btnfragmentB:
                fragment = new FragmentB();

                break;
        }
        fragmentTransaction.replace(R.id.fragmentContent, fragment);
        fragmentTransaction.commit();

    }
}
