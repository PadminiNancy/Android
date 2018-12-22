package com.example.sendrecieve;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Send extends Activity {
	
	Button b1;
	EditText t1;
	String n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        
        b1 = (Button) findViewById(R.id.button1);
        t1 = (EditText)findViewById(R.id.editText1);
        
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				n = t1.getText().toString();
        
        		Intent i = new Intent(Send.this,Recieve.class);
        		
        		  i.putExtra("Value1", "Hello");  
                  i.putExtra("Value2", n);  
        		startActivity(i);
        	}
        
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.send, menu);
        return true;
    }
    
}
