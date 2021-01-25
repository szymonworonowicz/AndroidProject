package com.example.cyclingstatsproject;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.cyclingstatsproject.Fragments.RaceFragment;
import com.google.android.material.snackbar.Snackbar;

public class StageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);




        if(savedInstanceState == null) {
            String stage_id = (String)getIntent().getSerializableExtra("STAGES_ID");
            Fragment newFragment = new RaceFragment(stage_id);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.stage_fragment_container,newFragment).commit();
        }



    }
    private final SensorEventListener LightSensorListener  = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.values[0] < 20000) {
                onBackPressed();
                Toast.makeText(getApplicationContext(),"zamknieto z powodu zbyt niskiego oswietlenia",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        SensorManager sensorManager =  (SensorManager)getSystemService(SENSOR_SERVICE);

        Sensor LightSensor  = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if(LightSensor != null) {
            sensorManager.registerListener(
                    LightSensorListener,
                    LightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL
            );
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SensorManager sensorManager =  (SensorManager)getSystemService(SENSOR_SERVICE);

        sensorManager.unregisterListener(LightSensorListener);
    }
}