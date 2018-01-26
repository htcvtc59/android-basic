package com.os.gesturezoominout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        scaleGestureDetector = new ScaleGestureDetector(this, new MyGesture());
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                scaleGestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });

    }

    private class MyGesture extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        float scale = 1.0F, onScaleStart = 0, onScaleEnd = 0;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale += detector.getScaleFactor();
            imageView.setScaleX(scale);
            imageView.setScaleY(scale);
            return super.onScale(detector);
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Toast.makeText(MainActivity.this, "onScaleBegin", Toast.LENGTH_SHORT).show();
            onScaleStart = scale;
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            Toast.makeText(MainActivity.this, "onScaleEnd", Toast.LENGTH_SHORT).show();
            onScaleEnd = scale;
            super.onScaleEnd(detector);
        }
    }
}
