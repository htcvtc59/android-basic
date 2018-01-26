package com.os.gestureleftrighttopbottom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    int[] mangHinh = {R.drawable.poke1, R.drawable.poke2, R.drawable.poke3};
    int pos;

    GestureDetector gestureDetector;
    int swipe_threshold = 100;
    int swipe_velocity_threshold = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(mangHinh[pos]);
        gestureDetector = new GestureDetector(this, new MyGesture());
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });

    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getX() - e1.getX() > swipe_threshold && Math.abs(velocityX) > swipe_velocity_threshold) {
                Toast.makeText(MainActivity.this, "left to right", Toast.LENGTH_SHORT).show();
                pos--;
                if (pos < 0) {
                    pos = mangHinh.length - 1;
                }
                imageView.setImageResource(mangHinh[pos]);
            }

            if (e1.getX() - e2.getX() > swipe_threshold && Math.abs(velocityX) > swipe_velocity_threshold) {
                Toast.makeText(MainActivity.this, "right to left ", Toast.LENGTH_SHORT).show();
                pos++;
                if (pos > mangHinh.length - 1) {
                    pos = 0;
                }
                imageView.setImageResource(mangHinh[pos]);
            }

            if (e2.getY() - e1.getY() > swipe_threshold && Math.abs(velocityY) > swipe_velocity_threshold) {
                Toast.makeText(MainActivity.this, "top to bottom", Toast.LENGTH_SHORT).show();
            }

            if (e1.getY() - e2.getY() > swipe_threshold && Math.abs(velocityY) > swipe_velocity_threshold) {
                Toast.makeText(MainActivity.this, "bottom to top", Toast.LENGTH_SHORT).show();
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
