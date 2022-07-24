package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {

    TimePicker Time;
    TextView Question;
    Button ScheduleAlarm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Time= (TimePicker) findViewById(R.id.TimePicker);
        Question=(TextView) findViewById(R.id.SelectedTimeMessage);
        ScheduleAlarm=(Button) findViewById(R.id.SelectedTimeButton);
        String SelectedTime=Time.getCurrentHour()+":"+Time.getCurrentMinute();


        ScheduleAlarm.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.SelectedTimeButton){
            startAlert();
        }

    }
    public void startAlert(){
        String SelectedTime=Time.getCurrentHour()+":"+Time.getCurrentMinute();
        Question.setText("Do you want to set Alarm at "+SelectedTime+"?");
        Toast.makeText(this,"Alarm will start at "+SelectedTime,Toast.LENGTH_LONG).show();


        int hour=Time.getCurrentHour();
        int minute=Time.getCurrentMinute();
        Date currentTime = Calendar.getInstance().getTime();
        int CurrentHour=currentTime.getHours();
        int CurrentMinute=currentTime.getMinutes();
        int CurrentSecond=currentTime.getSeconds();
        String time=currentTime.getHours()+":"+currentTime.getMinutes();

        int HourDiff=hour-CurrentHour;
        int MinuteDiff=minute-CurrentMinute;
        int SecondDiff=CurrentSecond;

        int i=(HourDiff*3600)+(MinuteDiff*60)-CurrentSecond;


        Intent intent = new Intent(this, Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i * 1000), pendingIntent);
    }

}