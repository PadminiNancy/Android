package com.example.timepicker;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	TextView mTimeDisplay;
	final Calendar c = Calendar.getInstance();
	int mHour,mMinute;
	TimePickerDialog timeDialog;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTimeDisplay = (TextView) findViewById(R.id.timeDisplay);
        
    }
    
    public void onClick(View v)
    {
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        
        TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
         
          public void onTimeSet(TimePicker view, int hourOfDay, int minute)
          {
        	  
        	  mHour = hourOfDay;
        	  mMinute = minute;
        	  mTimeDisplay.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
          }
        	
        };
    
        timeDialog = new TimePickerDialog(MainActivity.this, mTimeSetListener, mHour, mMinute, false);
        timeDialog.show();
        
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
