package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TimeSpanActivity extends AppCompatActivity implements View.OnClickListener {

    TextView TimeSpanTextView;
    TextView SecondTextView;
    Button EnterButton;
    EditText Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_span);

        TimeSpanTextView=(TextView) findViewById(R.id.timeSpanTextView);
        SecondTextView=(TextView) findViewById(R.id.secTextViewId);
        EnterButton= (Button) findViewById(R.id.button);
        Number= (EditText) findViewById(R.id.editTextNumber);

        EnterButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        startAlert();
        Toast.makeText(this,"Alarm will start after "+Number.getText()+" second!",Toast.LENGTH_LONG).show();
    }

    public void startAlert(){

        int i = Integer.parseInt(Number.getText().toString());
        Intent intent = new Intent(this, Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i * 1000), pendingIntent);

    }
}