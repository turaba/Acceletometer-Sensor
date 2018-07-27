package com.turaba.accelerometerSensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private float tvX,tvY,tvZ;
    private SensorManager mSensorManager;
    private float mLastX,mLastY,mLastZ;
    TextView tvXaxis,tvYaxis,tvZaxis;
    private boolean mInitialized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        tvXaxis=findViewById(R.id.tv_x);
        tvYaxis=findViewById(R.id.tv_y);
        tvZaxis=findViewById(R.id.tv_z);

    }

    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }


    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        if (!mInitialized) {
            mLastX = x;
            mLastY = y;
            mLastZ = z;
            tvXaxis.setText("0.0");
            tvYaxis.setText("0.0");
            tvZaxis.setText("0.0");
            mInitialized = true;
        } else {

            float deltaX = Math.abs(mLastX - x);
            float deltaY = Math.abs(mLastY - y);
            float deltaZ = Math.abs(mLastZ - z);

            mLastX = x;
            mLastY = y;
            mLastZ = z;


            tvXaxis.setText(Float.toString(deltaX));
            tvYaxis.setText(Float.toString(deltaY));
            tvZaxis.setText(Float.toString(deltaZ));

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
