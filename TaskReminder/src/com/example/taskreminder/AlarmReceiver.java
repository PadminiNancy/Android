package com.example.taskreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

     @Override
     public void onReceive(Context context, Intent intent) {
     // When our Alaram time is triggered , this method will be excuted (onReceive)
     // We're invoking a service in this method which shows Notification to the User
     	 
    	
    	
    	 long row = intent.getLongExtra("rowid",99);
      Intent myIntent = new Intent(context, NotificationService.class);
      myIntent.putExtra("rowid", row);
      context.startService(myIntent);
    }

} 