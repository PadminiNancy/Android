package com.example.newdb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecActivity extends Activity {

	DbAdapter d;
	long roll;
	EditText e;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec);
		
		d = new DbAdapter(this);
		e = (EditText) findViewById(R.id.roll);
	}

	public void onDisplay(View v)
	{
		roll = Long.parseLong(e.getText().toString());
		d.open();
		Cursor c = d.getDetail(roll);
		if(c.moveToFirst())
			
			displayDetails(c);
		else
			
			Toast.makeText(getApplicationContext(), "Invalid Roll No.", Toast.LENGTH_SHORT).show();
		
	}
	
	public void displayDetails(Cursor c)
    {
    	
    	Toast.makeText(getApplicationContext(), "roll "+c.getString(0)+"\n"+"Name : "+c.getString(1)+"\n"+"Email : "+c.getString(2), Toast.LENGTH_LONG).show();
    	
    }
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sec, menu);
		return true;
	}

}
