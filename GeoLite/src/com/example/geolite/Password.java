package com.example.geolite;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Password extends Activity {

	long row;
	//DbAdapter db;
	TextView n,p;
	String name,pass,r;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_password);
		
		
		n = (TextView) findViewById(R.id.vname);
		p = (TextView) findViewById(R.id.vpass);
		Bundle extras = getIntent().getExtras();
	    name = extras.getString("name");
	    pass = extras.getString("pass");
	    r = extras.getString("row");
			n.setText(extras.getString("name"));
			p.setText(extras.getString("pass"));
			
		
	}

	public void onUpdate(View v)
	{
		
		Intent i = new Intent(getApplicationContext(),Accounts.class);
        i.putExtra("upname", name);
        i.putExtra("uppass", pass);
       // i.putExtra("row", r);
        startActivity(i);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.password, menu);
		return true;
	}

}
