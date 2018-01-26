package com.os.gestureshake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    ShakeDectector shakeDectector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        shakeDectector.setOnShakeListener(new ShakeDectector.OnShakeListener() {
            @Override
            public void OnShake(int count) {
                Toast.makeText(MainActivity.this, "Shake" + count, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(shakeDectector,sensor,SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(shakeDectector);
    }
}
