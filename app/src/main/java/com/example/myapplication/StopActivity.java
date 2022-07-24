package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class StopActivity extends AppCompatActivity implements View.OnClickListener {
    Button Stop;
    Ringtone ringtone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        Stop= (Button) findViewById(R.id.StopButton);
        Stop.setOnClickListener(this);

        Date currentTime = Calendar.getInstance().getTime();
        String time=currentTime.getHours()+":"+currentTime.getMinutes();
        Toast.makeText(this, "Alarm started at "+time, Toast.LENGTH_LONG).show();





        //ringtone = (Ringtone) getIntent().getSerializableExtra("tone");




    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Alarm stopped ", Toast.LENGTH_LONG).show();
        //ringtone.stop();
        super.onDestroy();

    }
}