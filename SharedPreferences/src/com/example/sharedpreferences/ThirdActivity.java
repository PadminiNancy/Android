package com.example.sharedpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.Toast;

public class ThirdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		SharedPreferences sh = getSharedPreferences("My Data", Context.MODE_PRIVATE);
		String n = sh.getString("name", "No Value");
		String p = sh.getString("pass", "No Value");
		
		Toast.makeText(getApplicationContext(), "Hello " +n +". Your password is "+p, Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
		
		
		
	}

}
