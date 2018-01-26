package com.os.floatingactionbuttontest;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_main, fab_google, fab_facebook, fab_twitter;
    boolean hideshow = false;


    FloatingActionButton fab_main2, fab_google2, fab_facebook2, fab_twitter2, fab_zalo;
    boolean hideshow2 = false;
    Animation move_left, move_right, move_top, move_bottom;

    Animation back_left, back_right, back_top, back_bottom;

    boolean moveback = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_main = (FloatingActionButton) findViewById(R.id.fab_main);
        fab_google = (FloatingActionButton) findViewById(R.id.fab_gogole);
        fab_facebook = (FloatingActionButton) findViewById(R.id.fab_facebook);
        fab_twitter = (FloatingActionButton) findViewById(R.id.fab_twitter);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hideshow) {
                    HideFab();
                    hideshow = false;
                } else {
                    ShowFab();
                    hideshow = true;
                }
            }
        });

        fab_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "google", Toast.LENGTH_SHORT).show();
            }
        });
        fab_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "facebook", Toast.LENGTH_SHORT).show();
            }
        });
        fab_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "twitter", Toast.LENGTH_SHORT).show();
            }
        });


        fab_main2 = (FloatingActionButton) findViewById(R.id.floating_btnmain);
        fab_google2 = (FloatingActionButton) findViewById(R.id.floating_btn_gogole);
        fab_facebook2 = (FloatingActionButton) findViewById(R.id.floating_btn_facebook);
        fab_twitter2 = (FloatingActionButton) findViewById(R.id.floating_btn_twitter);
        fab_zalo = (FloatingActionButton) findViewById(R.id.floating_btn_zalo);


        move_left = AnimationUtils.loadAnimation(this, R.anim.move_left);
        move_right = AnimationUtils.loadAnimation(this, R.anim.move_right);
        move_bottom = AnimationUtils.loadAnimation(this, R.anim.move_bottom);
        move_top = AnimationUtils.loadAnimation(this, R.anim.move_top);


        back_left = AnimationUtils.loadAnimation(this, R.anim.back_left);
        back_right = AnimationUtils.loadAnimation(this, R.anim.back_right);
        back_bottom = AnimationUtils.loadAnimation(this, R.anim.back_bottom);
        back_top = AnimationUtils.loadAnimation(this, R.anim.back_top);


        fab_main2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (moveback) {
                    Back();
                    moveback = false;
                } else {
                    Move();
                    moveback = true;
                }
            }
        });

        fab_google2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "fab_google2", Toast.LENGTH_SHORT).show();
            }
        });

        fab_facebook2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "fab_facebook2", Toast.LENGTH_SHORT).show();
            }
        });

        fab_twitter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "fab_twitter2", Toast.LENGTH_SHORT).show();
            }
        });

        fab_zalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "fab_zalo", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Move() {
        FrameLayout.LayoutParams paramsleft = (FrameLayout.LayoutParams) fab_google2.getLayoutParams();
        paramsleft.rightMargin = (int) (fab_google2.getWidth() * 1.4);
        fab_google2.setLayoutParams(paramsleft);
        fab_google2.startAnimation(move_left);

        FrameLayout.LayoutParams paramseright = (FrameLayout.LayoutParams) fab_facebook2.getLayoutParams();
        paramseright.leftMargin = (int) (fab_facebook2.getWidth() * 1.4);
        fab_facebook2.setLayoutParams(paramseright);
        fab_facebook2.startAnimation(move_right);


        FrameLayout.LayoutParams paramsetop = (FrameLayout.LayoutParams) fab_twitter2.getLayoutParams();
        paramsetop.bottomMargin = (int) (fab_twitter2.getWidth() * 1.4);
        fab_twitter2.setLayoutParams(paramsetop);
        fab_twitter2.startAnimation(move_top);

        FrameLayout.LayoutParams paramsebottom = (FrameLayout.LayoutParams) fab_zalo.getLayoutParams();
        paramsebottom.topMargin = (int) (fab_zalo.getWidth() * 1.4);
        fab_zalo.setLayoutParams(paramsebottom);
        fab_zalo.startAnimation(move_bottom);
    }

    private void Back() {
        FrameLayout.LayoutParams paramsleft = (FrameLayout.LayoutParams) fab_google2.getLayoutParams();
        paramsleft.rightMargin -= (int) (fab_google2.getWidth() * 1.4);
        fab_google2.setLayoutParams(paramsleft);
        fab_google2.startAnimation(back_left);

        FrameLayout.LayoutParams paramseright = (FrameLayout.LayoutParams) fab_facebook2.getLayoutParams();
        paramseright.leftMargin -= (int) (fab_facebook2.getWidth() * 1.4);
        fab_facebook2.setLayoutParams(paramseright);
        fab_facebook2.startAnimation(back_right);


        FrameLayout.LayoutParams paramsetop = (FrameLayout.LayoutParams) fab_twitter2.getLayoutParams();
        paramsetop.bottomMargin -= (int) (fab_twitter2.getWidth() * 1.4);
        fab_twitter2.setLayoutParams(paramsetop);
        fab_twitter2.startAnimation(back_top);

        FrameLayout.LayoutParams paramsebottom = (FrameLayout.LayoutParams) fab_zalo.getLayoutParams();
        paramsebottom.topMargin -= (int) (fab_zalo.getWidth() * 1.4);
        fab_zalo.setLayoutParams(paramsebottom);
        fab_zalo.startAnimation(back_bottom);
    }

    private void HideFab() {
        fab_google.hide();
        fab_facebook.hide();
        fab_twitter.hide();
    }


    private void ShowFab() {
        fab_google.show();
        fab_facebook.show();
        fab_twitter.show();
    }
}
