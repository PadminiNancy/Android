package com.example.alarmnotify;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView t ;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		
		Calendar c = Calendar.getInstance();
	   long b = c.getTimeInMillis();
		c.set(Calendar.MONTH, 6);
		c.set(Calendar.YEAR, 2016);
		c.set(Calendar.DAY_OF_MONTH, 8);

		c.set(Calendar.HOUR_OF_DAY, 11);
		c.set(Calendar.MINUTE, 29);
		c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        
       
		
		Intent myIntent = new Intent(MainActivity.this, AlarmReceiver.class);

		PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,
				0, myIntent, 0);

		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
       long v = c.getTimeInMillis();
       long tc = v-b;
		

		alarmManager.set(AlarmManager.RTC, c.getTimeInMillis(),
				pendingIntent);
		
		//Toast.makeText(getApplicationContext(), Long.toString(b)+"\n"+Long.toString(v)+"\n"+Long.toString(tc), Toast.LENGTH_LONG).show();
	}
}