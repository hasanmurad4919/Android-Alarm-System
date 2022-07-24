package com.example.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Vibrator;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Receiver extends BroadcastReceiver {
//    private final Context context;
//
//    public Receiver(Context context) {
//        this.context = context;
//    }
//    @Override
//    public void onComplete(Bundle values) {
//        MainActivity.showInLog(values.toString());
//
//        Intent i1 = new Intent (context, StopActivity.class);
//        context.startActivity(i1);
//    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(4000);
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        // setting default ringtone
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);

        // play ringtone
        ringtone.play();


        //Receiver.this.context.startActivity(new Intent(Receiver.this.context,StopActivity.class));
        //this.context.startActivity(new Intent(this.context,StopActivity.class));

        Intent i = new Intent(context, StopActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //i.putExtra("tone", (Parcelable) ringtone);
        context.startActivity(i);

    }
}
