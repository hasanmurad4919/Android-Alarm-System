package com.example.androidalarmclock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidalarmclock.databinding.ActivityMainBinding;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView mTextView;
    private ActivityMainBinding binding;

    private Button SetButton;
    private Button ScheduleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        mTextView = binding.text;

        SetButton= (Button) findViewById(R.id.SetButton);
        ScheduleButton= (Button) findViewById(R.id.ScheduleButton);
        SetButton.setOnClickListener(this);
        ScheduleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.SetButton){
            Toast.makeText(MainActivity.this,"Alarm will ring after",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.ScheduleButton){
            Toast.makeText(MainActivity.this,"Alarm ",Toast.LENGTH_SHORT).show();

        }

    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           