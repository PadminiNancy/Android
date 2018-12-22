package com.example.activityforresult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText e1,e2,e3;
    Button b;
    String r,t,p;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        
        
               
    }
    
    public void onClick(View v)
    
    {
    	p = e1.getText().toString();
    	r = e2.getText().toString();
        t = e3.getText().toString();
      
    	Intent i = new Intent(getApplicationContext(),SecondActivity.class);
    	
    	
    	Bundle extras = new Bundle();
    	
    	extras.putString("prin",p);
    	extras.putString("rate", r);
    	extras.putString("time", t);
    	
    	i.putExtras(extras);
    	
    	startActivityForResult(i, 1);
    	
    	
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	
    	if(requestCode==1)
    	{
    		if(resultCode==RESULT_OK)
    		{
    			
    			Toast.makeText(getApplicationContext(), data.getData().toString(), Toast.LENGTH_LONG).show();
    			
    		}
    	}
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
