package com.example.taskreminder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class NotifyViewActivity extends Activity {

	TextView t,b,d,ti;
	RemindersDbAdapter db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notify_view);
		
		t = (TextView) findViewById(R.id.ntitle);
		b = (TextView) findViewById(R.id.ndes);
		d = (TextView) findViewById(R.id.ndate);
		ti = (TextView) findViewById(R.id.ntime);
		
		 
        //SharedPreferences sh = getSharedPreferences("Task Data", Context.MODE_PRIVATE);
        //long rowid = sh.getLong("si", 0);
		Bundle extras = getIntent().getExtras();
		long row = extras.getLong("rowid", 77);
        
       db = new RemindersDbAdapter(NotifyViewActivity.this);
       db.open();
       Cursor c = db.fetchReminder(row);
       if(c.moveToFirst())
   	{
			t.setText(c.getString(1)+"\n");
    	  // t.setText(Long.toString(row));
			b.setText(c.getString(2)+"\n");
			String dt = c.getString(3);
			String dd = dt.substring(0,10);
			String tt = dt.substring(11,16);
			d.setText(dd+"\n");
			ti.setText(tt+"\n");
			
			
   	}
        
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notify_view, menu);
		return true;
	}

}
