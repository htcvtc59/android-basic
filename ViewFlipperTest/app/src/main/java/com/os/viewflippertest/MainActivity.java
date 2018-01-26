package com.os.viewflippertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Animation animationin, animationout;
    Button btnPre, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewfipper);
        animationin = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animationout = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        btnPre = (Button) findViewById(R.id.button);
        btnNext = (Button) findViewById(R.id.button2);


        viewFlipper.setInAnimation(animationin);
        viewFlipper.setOutAnimation(animationout);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewFlipper.isAutoStart()) {
                    viewFlipper.stopFlipping();
                    viewFlipper.showNext();
                    viewFlipper.stopFlipping();
                    viewFlipper.setAutoStart(true);
                }
            }
        });

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewFlipper.isAutoStart()) {
                    viewFlipper.stopFlipping();
                    viewFlipper.showPrevious();
                    viewFlipper.stopFlipping();
                    viewFlipper.setAutoStart(true);
                }

            }
        });

    }
}
