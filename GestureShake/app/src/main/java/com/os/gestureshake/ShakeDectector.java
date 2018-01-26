package com.os.gestureshake;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by MacOS on 26/01/2018.
 */

public class ShakeDectector implements SensorEventListener {
    float SHAKE_THRESHOLD_GRAVITY = 2.0F;
    int SHAKE_SLOP_TIME_MS = 500;
    int SHAKE_COUNT_RESET_TIME_MS = 3000;

    public OnShakeListener listener;
    public float mShakeTimestamp;
    public int mShakeCount;

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.listener = onShakeListener;
    }

    public interface OnShakeListener {
        public void OnShake(int count);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (listener != null) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            float gx = x / SensorManager.GRAVITY_EARTH;
            float gy = y / SensorManager.GRAVITY_EARTH;
            float gz = z / SensorManager.GRAVITY_EARTH;

            float gForce = (float) Math.sqrt(gx * gx + gy * gy + gz * gz);
            if (gForce > SHAKE_THRESHOLD_GRAVITY) {
                float now = System.currentTimeMillis();
                if (mShakeTimestamp + SHAKE_SLOP_TIME_MS > now) {
                    return;
                }
                if (mShakeTimestamp + SHAKE_COUNT_RESET_TIME_MS < now) {
                    mShakeCount = 0;
                }
                mShakeTimestamp = now;
                mShakeCount++;
                listener.OnShake(mShakeCount);
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
