package com.example.intentfilter;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button b1,b2,b3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        
        b1.setOnClickListener(new View.OnClickListener() { 
        	public void onClick(View view) { 
               Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.example.com")); 
        		startActivity(i); 
        		} 
        	});
        
        b2.setOnClickListener(new View.OnClickListener() 
        { 
        	public void onClick(View view) 
        	{ 
        		Intent i = new Intent("com.example.intentdemo.LAUNCH", Uri.parse("http://www.example.com")); 
        		startActivity(i); 
        		} 
        	});
        
        b3.setOnClickListener(new View.OnClickListener() 
        { 
        	public void onClick(View view) { 
        		Intent i = new Intent("com.example.intentdemo.LAUNCH", Uri.parse("https://www.example.com")); 
        		startActivity(i); 
        		} 
        	});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
