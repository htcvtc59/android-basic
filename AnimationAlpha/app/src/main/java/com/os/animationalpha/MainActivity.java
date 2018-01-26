package com.os.animationalpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView,imageView2,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= (ImageView)findViewById(R.id.imageView);
        imageView2= (ImageView)findViewById(R.id.imageView2);
        imageView3= (ImageView)findViewById(R.id.imageView3);
        imageView4= (ImageView)findViewById(R.id.imageView4);

        final Animation animationAlpha = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationAlpha);
            }
        });


        final Animation animationRotate = AnimationUtils.loadAnimation(this,R.anim.anim_rotate);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationRotate);
            }
        });


        final Animation animationScale = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationScale);
            }
        });


        final Animation animationTranslate = AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animationTranslate);
            }
        });

    }
}
