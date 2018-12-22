package com.example.alarmnotify;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class NotifyViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notify_view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notify_view, menu);
		return true;
	}

}
