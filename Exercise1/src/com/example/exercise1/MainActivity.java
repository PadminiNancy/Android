package com.example.exercise1;

import android.os.Bundle;
import android.app.Activity;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView t1,t2,result;
	EditText e1,e2;
	RadioButton r1,r2,r3,r4;
	double n1,n2,r;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        result = (TextView) findViewById(R.id.textView3);
        r1 = (RadioButton) findViewById(R.id.radioButton1);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);
        
        
    }
    
   public void onClickResult(View v)
    {
    	boolean checked = ((RadioButton)v).isChecked();
    	switch(v.getId())
    	{
    	case R.id.radioButton1:
    		if(checked)
    		{
    			n1 = Double.parseDouble(e1.getText().toString());
    	        n2 = Double.parseDouble(e2.getText().toString());
    			r = n1+n2;
    			//s = Integer.parseInt(Double.toString(r));
    			Toast.makeText(getBaseContext(), "Your Desired result is "+Double.toString(r), 1).show();
    			//result.setText(Double.toString(r));
    			break;
    		}
    		
    	case R.id.radioButton2:
    		if(checked)
    		{
    			n1 = Double.parseDouble(e1.getText().toString());
    	        n2 = Double.parseDouble(e2.getText().toString());
    			r = n1-n2;
    			//s = Integer.parseInt(Double.toString(r));
    			
    			Toast.makeText(getBaseContext(), "Your Desired result is "+Double.toString(r), 1).show();
    			//result.setText(Double.toString(r));
    			break;
    		}
    		
    	case R.id.radioButton3:
    		if(checked)
    		{
    			n1 = Double.parseDouble(e1.getText().toString());
    	        n2 = Double.parseDouble(e2.getText().toString());
    			r = n1*n2;
    			//s = Integer.parseInt(Double.toString(r));
    			Toast.makeText(getBaseContext(), "Your Desired result is "+Double.toString(r), 1).show();
    			//result.setText(Double.toString(r));
    			break;
    		}
    	
    	case R.id.radioButton4:
    		if(checked)
    		{
    			n1 = Double.parseDouble(e1.getText().toString());
    	        n2 = Double.parseDouble(e2.getText().toString());
    			r = n1/n2;
    			//s = Integer.parseInt(Double.toString(r));
    			Toast.makeText(getBaseContext(), "Your Desired result is "+Double.toString(r), 1).show();
    			//result.setText(Double.toString(r));
    			break;
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
