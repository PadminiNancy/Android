package com.example.geolite;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PinSuccess extends Activity {

	TextView t,t4,wen;
	int en,diff=0,rev=0;
	EditText d;
	RadioButton yes,no;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin_success);
		t = (TextView) findViewById(R.id.t1);
		t4 = (TextView) findViewById(R.id.textView4);
		d = (EditText) findViewById(R.id.diff);
		wen = (TextView) findViewById(R.id.textView5);
		yes = (RadioButton) findViewById(R.id.radioButton0);
		no = (RadioButton) findViewById(R.id.radioButton1);
		int p;
		Intent i = new Intent();
		Bundle extras = getIntent().getExtras();
		p = extras.getInt("pin");
		t.setText(Integer.toString(p));
		SharedPreferences sh = getSharedPreferences("MyData", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sh.edit();
		editor.putInt("pin", p);
		editor.commit();
	}
	
	public void onRadio(View v)
	{
		boolean checked = ((RadioButton)v).isChecked();
    	switch(v.getId())
    	{
    	case R.id.radioButton0:
    		if(checked)
    		{
    			en = 1;
    			
    			//Toast.makeText(getApplicationContext(), "yes", 1).show();
    			t4.setText("Enter the no. of difference you want in your password :");
    			d.setVisibility(1);
    		}
    		break;
    	case R.id.radioButton1:
    		if(checked)
    		{
    			en = 0;
    			diff = 0;
    			//Toast.makeText(getApplicationContext(), "no", 1).show();
    			t4.setText("");
    			d.setVisibility(-1);
    			wen.setText("");
    		}
        }
		
	}

	public void onReverse(View v)
	{
		boolean checked = ((RadioButton)v).isChecked();
    	switch(v.getId())
    	{
    	case R.id.rradioButton0:
    		if(checked)
    		{
    			rev = 1;
    		}
    		break;
    	case R.id.rradioButton1:
    		if(checked)
    		{
    			rev = 0;
    		}
        }
		
	}

	
	public void onStart(View v)
	{

		if(en==1)
			diff = Integer.parseInt(d.getText().toString());
		if(diff<0){
			wen.setText("please enter a positive number");
		}
		else
		{
		SharedPreferences sh = getSharedPreferences("MyData", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sh.edit();
		editor.putInt("diff",diff);
		editor.putInt("reverse",rev);
		editor.commit();
		
		Intent i = new Intent(getApplicationContext(),YourInfo.class);
    	startActivity(i);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pin_success, menu);
		return true;
	}

}
