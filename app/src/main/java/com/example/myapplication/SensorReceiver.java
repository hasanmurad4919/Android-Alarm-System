package com.example.myapplication;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.media.MediaDescription;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


public class SensorReceiver extends BroadcastReceiver {

    public static float temp;

    @Override
    public void onReceive(Context context, Intent intent) {


        Toast toast = Toast.makeText(context, temp+ "°C", Toast.LENGTH_LONG);
        toast.show();


    }

}
