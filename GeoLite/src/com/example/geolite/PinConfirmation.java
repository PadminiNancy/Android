package com.example.geolite;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PinConfirmation extends Activity {

	TextView ep;
	EditText cp;
	int pin;
	String p;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin_confirmation);
		

        ep = (TextView) findViewById(R.id.pinError);
        cp = (EditText) findViewById(R.id.conPin);
        
        
		
	}

	public void onGo(View v)
	{
	
		pin = Integer.parseInt(cp.getText().toString());
		

		SharedPreferences sh = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        int n = sh.getInt("pin", 0);
		
        if(n==pin)
		{
        	Intent i = new Intent(getApplicationContext(),Accounts.class);
	    	startActivity(i);
		}
		
		else
		{
			ep.setText("Invalid Pin!!!");			
		}
        
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pin_confirmation, menu);
		return true;
	}

}
