package com.example.activityforresult;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends Activity {

	double p,r,t,a;
	String p1,r1,t1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Bundle bundle = getIntent().getExtras();
		
		try
		{
		p1= bundle.getString("prin");
		r1 = bundle.getString("rate");
		t1 = bundle.getString("time");
		
		
		p = Double.parseDouble(p1);
		r = Double.parseDouble(r1);
		t = Double.parseDouble(t1);
			
		a = p + (p*r*t)/100;
			Toast.makeText(getApplicationContext(), Double.toString(a), Toast.LENGTH_LONG).show();
		
		}
		
		catch(Exception e){
			
          Intent i = new Intent();
			
			
			i.setData(Uri.parse("Null Value Encountered"));
			
			setResult(RESULT_OK, i);
			finish();
			
		}
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
