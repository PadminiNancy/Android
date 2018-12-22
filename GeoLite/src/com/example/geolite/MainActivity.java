package com.example.geolite;

import java.util.Random;



import android.os.Bundle;
import android.accounts.AccountsException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SharedPreferences sh = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        int n = sh.getInt("pin", 0);
		
		if(n==0)
		{
			String a = "a";
		}
		
		else
		{
			Intent i = new Intent(getApplicationContext(),PinConfirmation.class);
	    	startActivity(i);
			
		}
        
    }

    public void onPin(View v)
    {
    	
    	 int n=0, a = 0,p;
         int min=1000, max=9999;
         n = max-min+1;
      Random r = new Random(); 
          a=r.nextInt(9999)%n;
          p = a+min;
     // System.out.println(a+min);
    	
          Intent i = new Intent(getApplicationContext(), PinSuccess.class);
    	  i.putExtra("pin", p);
    	  
    	  startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
