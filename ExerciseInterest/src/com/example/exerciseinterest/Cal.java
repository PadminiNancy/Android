package com.example.exerciseinterest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Cal extends Activity {

	TextView at;
	double a;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cal);
		
		at  = (TextView) findViewById(R.id.Result);


		Bundle extras = getIntent().getExtras();
		
		String v1 = extras.getString("p");
		String v2 = extras.getString("r");
		String v3 = extras.getString("t");
		
		
		
		double p = Double.parseDouble(v1); 
		double r = Double.parseDouble(v2);
		double t = Double.parseDouble(v3);
		
		a = p + ((p*r*t)/100);
		
	
		//Toast.makeText(getApplicationContext(), "Your Total Amount Will be"+Double.toString(a),1).show();
	  at.setText("Your Total Amount Will be "+Double.toString(a));
	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cal, menu);
		return true;
	}

}
