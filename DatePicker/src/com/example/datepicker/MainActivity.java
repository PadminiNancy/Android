package com.example.datepicker;



import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView mDateDisplay;
    DatePickerDialog dateDialog;
    final Calendar c = Calendar.getInstance();
	int mYear,mMonth,mDay;
	 private static final String DATE_FORMAT = "yyyy-MM-dd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mDateDisplay = (TextView) findViewById(R.id.mDateDisplay);
        
    }
    
    public void onClick(View v)
    {
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        
        DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener()
        {
        	public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        	{
        		  
        		c.set(Calendar.YEAR, year); 
        		c.set(Calendar.MONTH, monthOfYear);
        		c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        		
        		updateDateButtonText();
        	}        
        };
        
        dateDialog = new DatePickerDialog(MainActivity.this,mDateSetListener,mYear,mMonth,mDay);
        dateDialog.show();
    }
    
    private void updateDateButtonText() { 
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT); 
		String dateForButton = dateFormat.format(c.getTime()); 
		mDateDisplay.setText(dateForButton); 
		}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
