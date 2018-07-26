package com.turaba.accelerometerSensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private TextView tvX,tvY,tvZ;
    //TextView tvX,tvY,tvZ;
    private SensorManager sM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        tvX=findViewById(R.id.Tv_x);
        tvY=findViewById(R.id.Tv_y);
        tvZ=findViewById(R.id.Tv_z);

        sM=(SensorManager)getSystemService(SENSOR_SERVICE);
        //create our sensor manager

        sM.registerListener(this,sM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tvX.setText("X"+event.values[0]);
        tvY.setText("Y"+event.values[0]);
        tvZ.setText("Z"+event.values[0]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
