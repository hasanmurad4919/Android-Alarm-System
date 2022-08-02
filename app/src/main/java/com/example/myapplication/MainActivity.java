package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener {
    Button SetButton;
    Button ScheduleButton;
    private SensorManager sensorManager;
    private Sensor Temperature;
    float temp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null){
            Temperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        }
        else{
            Toast.makeText(this, temp+ "No temperatue sensor available", Toast.LENGTH_LONG).show();
        }

        startSensorAlert();


        SetButton= (Button) findViewById(R.id.SetAlarmButton);
        ScheduleButton=(Button) findViewById(R.id.ScheduleAlarmButton);
        SetButton.setOnClickListener(this);
        ScheduleButton.setOnClickListener(this);


    }
    public void startSensorAlert(){

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, SensorReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                , 1000 * 60 * 10, pendingIntent);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.SetAlarmButton){
            Intent intent= new Intent(MainActivity.this,TimeSpanActivity.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.ScheduleAlarmButton){
            Intent intent= new Intent(MainActivity.this,ScheduleActivity.class);
            startActivity(intent);

        }
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
         temp = sensorEvent.values[0];
         SensorReceiver.temp=temp;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, Temperature, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        sensorManager.unregisterListener(this);
    }



}