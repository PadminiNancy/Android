package com.example.newdb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	DbAdapter d;
	EditText t1,t2;
	String n,s;
	int i = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       
        t1 = (EditText) findViewById(R.id.name);
        t2 = (EditText) findViewById(R.id.email);
        d = new DbAdapter(this); 
       
    }
    
   
    
    
    public void onInsert(View v)
    {
    	d.open();
    	n =t1.getText().toString();
    	s = t2.getText().toString();
    	d.insertStud(n, s);
    	d.close();
    	Toast.makeText(getApplicationContext(), "Inserted Successfully!!!!", Toast.LENGTH_LONG).show();
    }
    
    
    
    public void displayDetails(Cursor c)
    {
    	
    	Toast.makeText(getApplicationContext(), "roll "+c.getString(0)+"\n"+"Name : "+c.getString(1)+"\n"+"Email : "+c.getString(2), Toast.LENGTH_LONG).show();
    	
    }

    
    public void onSearch(View v)
    {
    	
    	Intent i = new Intent(getApplicationContext(),SecActivity.class);
    	startActivity(i);
    	
    }
    
    public void onVList(View v)
    {
    	Intent i = new Intent(getApplicationContext(),DbListActivity.class);
    	startActivity(i);
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
