package com.os.gesturedraganddrop;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    int mode = 0;
    int drag = 1;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(250, 250);

        layoutParams.leftMargin = 50;
        layoutParams.topMargin = 50;
        imageView.setLayoutParams(layoutParams);

        final RelativeLayout.LayoutParams[] paramsRe = new RelativeLayout.LayoutParams[1];

        final float[] dx = {0};
        final float[] dy = {0};
        final float[] x = {0};
        final float[] y = {0};

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageView imageView = (ImageView) view;
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        paramsRe[0] = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                        dx[0] = motionEvent.getRawX() - paramsRe[0].leftMargin;
                        dy[0] = motionEvent.getRawY() - paramsRe[0].topMargin;
                        mode = drag;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (mode == drag) {
                            x[0] = motionEvent.getRawX();
                            y[0] = motionEvent.getRawY();
                            paramsRe[0].leftMargin = (int) (x[0] - dx[0]);
                            paramsRe[0].topMargin = (int) (y[0] - dy[0]);

                            paramsRe[0].rightMargin = 0;
                            paramsRe[0].bottomMargin = 0;

                            paramsRe[0].rightMargin = paramsRe[0].leftMargin + (5 * paramsRe[0].width);
                            paramsRe[0].bottomMargin = paramsRe[0].topMargin + (5 * paramsRe[0].height);

                            imageView.setLayoutParams(paramsRe[0]);

                        }
                        break;
                }


                return true;
            }
        });


    }


}
