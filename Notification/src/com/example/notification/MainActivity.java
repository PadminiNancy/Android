package com.example.notification;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	int notificationID = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
    	displayNotification();
    	}
    	protected void displayNotification()
    	{
    	//---PendingIntent to launch activity if the user selects
    	// this notification---
    	Intent i = new Intent(this, NotificationView.class);
    	i.putExtra("notificationID", notificationID);
    	PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
    	NotificationManager nm = (NotificationManager)
    	getSystemService(NOTIFICATION_SERVICE);
    	Notification notif = new Notification(R.drawable.and_img3,
    	"Reminder: Meeting starts in 5 minutes",
    	System.currentTimeMillis());
    	CharSequence from = "System Alarm";
    	CharSequence message = "Meeting with customer at 3pm...";
    	notif.setLatestEventInfo(this, from, message, pendingIntent);
    	//---100ms delay, vibrate for 250ms, pause for 100 ms and
    	// then vibrate for 500ms---
    	notif.vibrate = new long[] { 100, 250, 100, 500};
    	nm.notify(notificationID, notif);
    	}
    	
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
