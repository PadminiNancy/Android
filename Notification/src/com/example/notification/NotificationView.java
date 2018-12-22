package com.example.notification;

import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.view.Menu;

public class NotificationView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_view);
		
		NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		//---cancel the notification that we started---
		nm.cancel(getIntent().getExtras().getInt("notificationID"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notification_view, menu);
		return true;
	}

}
