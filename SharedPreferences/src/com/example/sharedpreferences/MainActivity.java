package com.example.sharedpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText e1,e2;
	Button b;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        b = (Button) findViewById(R.id.button1);
        
        SharedPreferences sh = getSharedPreferences("My Data", Context.MODE_PRIVATE);
        String n = sh.getString("name", "No Value");
		String p = sh.getString("pass", "No Value");
		
		if(n.equals("No Value")||p.equals("No Value"))
		{
			String a = "a";
			//Intent i = new Intent(getApplicationContext(),MainActivity.class);
	    	//startActivity(i);
		}
		
		else
		{
			Intent i = new Intent(getApplicationContext(),ThirdActivity.class);
	    	startActivity(i);
			
		}
        
        
    }
    
    public void onClick(View v)
    {
    	
    	SharedPreferences sh = getSharedPreferences("My Data", Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = sh.edit();
    	editor.putString("name", e1.getText().toString());
    	editor.putString("pass", e2.getText().toString());
    	editor.commit();
    	Intent i = new Intent(getApplicationContext(),SecActivity.class);
    	startActivity(i);
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
