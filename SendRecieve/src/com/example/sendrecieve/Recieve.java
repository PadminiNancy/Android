package com.example.sendrecieve;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Recieve extends Activity {
	
	TextView t1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recieve);
		
		
		t1 = (TextView) findViewById(R.id.textView1);
		Bundle extras = getIntent().getExtras();  
	    String value1 = extras.getString("Value1");  
	    String value2 = extras.getString("Value2");  
	    //Toast.makeText(getApplicationContext(),value1+"  "+value2,Toast.LENGTH_LONG).show(); 
	    
	    t1.setText(value1+" "+value2);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recieve, menu);
		return true;
	}

}
