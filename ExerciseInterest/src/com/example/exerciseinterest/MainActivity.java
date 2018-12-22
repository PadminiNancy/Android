package com.example.exerciseinterest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText e1,e2,e3;
	Button b;
	double p;
	int r,t;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        b = (Button) findViewById(R.id.button1);
        
       b.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			
			
	    	
	    	Intent i = new Intent(getApplicationContext(),Cal.class);
	    	
	    	i.putExtra("p", e1.getText().toString());
	    	i.putExtra("r", e2.getText().toString());
	    	i.putExtra("t", e3.getText().toString()); 
	    	
	    	startActivity(i);
	    	
	    	//Toast.makeText(getApplicationContext(), Double.toString(p), 1).show();
			
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
