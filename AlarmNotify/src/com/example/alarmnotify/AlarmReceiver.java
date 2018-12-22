package com.example.alarmnotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

     @Override
     public void onReceive(Context context, Intent intent) {
     // When  Alaram time is triggered , this method will be excuted (onReceive)
     // invoking a service in this method which shows Notification to the User
      Intent myIntent = new Intent(context, NotificationService.class);
      context.startService(myIntent);
    }

} 