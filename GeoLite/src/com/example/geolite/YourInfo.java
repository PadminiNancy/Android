package com.example.geolite;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class YourInfo extends Activity {
	TextView info1,info2,info3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_your_info);
		
		info1 = (TextView) findViewById(R.id.info1);
		info2 = (TextView) findViewById(R.id.info2);
		info3 = (TextView) findViewById(R.id.info3);
		
		SharedPreferences sh = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        int p = sh.getInt("pin", 0);
        int d = sh.getInt("diff", 0);
        int r = sh.getInt("reverse", 0);
        
        info1.setText("Your Visibility pin is "+p);
        info2.setText("Your password difference is "+d);
        if(r==0)
        	info3.setText("your password wont be reversed.");
        else
        	info3.setText("your password will be reversed.");
        		
	}
	
	public void onStart(View v)
	{
		
		 Intent i = new Intent(getApplicationContext(),Accounts.class);
	      startActivity(i);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.your_info, menu);
		return true;
	}

}
