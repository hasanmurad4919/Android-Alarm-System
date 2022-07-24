package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button SetButton;
    Button ScheduleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetButton= (Button) findViewById(R.id.SetAlarmButton);
        ScheduleButton=(Button) findViewById(R.id.ScheduleAlarmButton);
        SetButton.setOnClickListener(this);
        ScheduleButton.setOnClickListener(this);

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
}