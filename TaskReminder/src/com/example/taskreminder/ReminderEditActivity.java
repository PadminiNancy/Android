package com.example.taskreminder;

import java.text.SimpleDateFormat;
import java.util.Calendar;



import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class ReminderEditActivity extends Activity {
 
	RemindersDbAdapter mDbHelper;
	private EditText mTitleText;
	private Button mConfirmButton;
	private EditText mBodyText;
	
	
	long rowId;
	TextView tl;
	Button mDateButton;
	DatePickerDialog dateDialog;
    final Calendar c = Calendar.getInstance();
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd kk:mm:ss";
	int mYear,mMonth,mDay;
	
	Button mTimeButton;
	int mHour,mMinute;
	TimePickerDialog timeDialog;
	private static final String TIME_FORMAT = "kk:mm";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder_edit);
		
        mDbHelper = new RemindersDbAdapter(this);
        
        mConfirmButton = (Button) findViewById(R.id.confirm);
        mTitleText = (EditText) findViewById(R.id.title);
        mBodyText = (EditText) findViewById(R.id.body);
		
		mDateButton = (Button)findViewById(R.id.reminder_date);
		mTimeButton = (Button) findViewById(R.id.reminder_time);
		
		tl = (TextView) findViewById(R.id.title);
	}
	
	/*private void fillData() {
    	
   	 mDbHelper.open();
        Cursor c = mDbHelper.fetchReminder(rowId);
        String r[] = new String[c.getCount()];
        
		if(c.moveToFirst())
    	{
			mTitleText.setText(c.getString(1));
			mBodyText.setText(c.getString(2));		
    	}
      						mDbHelper.close();
   	
   }*/
	
	
	
	private void saveState() {
		String title = mTitleText.getText().toString(); 
		String body = mBodyText.getText().toString(); 
		SimpleDateFormat dateTimeFormat = new
		SimpleDateFormat(DATE_TIME_FORMAT);
		String reminderDateTime = dateTimeFormat.format(c.getTime());
		mDbHelper.open();
		long id = mDbHelper.createReminder(title, body, reminderDateTime);
		
		String rid = Long.toString(id);
		
		Intent myIntent = new Intent(ReminderEditActivity.this, AlarmReceiver.class);
       
		myIntent.putExtra("rowid", id);
	
		PendingIntent pendingIntent = PendingIntent.getBroadcast(ReminderEditActivity.this,
				Integer.parseInt(rid), myIntent, PendingIntent.FLAG_ONE_SHOT);

		
		
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

		alarmManager.set(AlarmManager.RTC, c.getTimeInMillis(),
				pendingIntent);
	}

	public void onDate(View v)
    {
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        
        DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener()
        {
        	public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        	{
        		  
        		//mDateDisplay.setText(new StringBuilder().append(mMonth+1).append("-").append(mDay).append("-").append(mYear).append(" "));
        		
        		c.set(Calendar.YEAR, year); 
        		c.set(Calendar.MONTH, monthOfYear);
        		c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        		updateDateButtonText();
        		
        	}        
        };
        
        dateDialog = new DatePickerDialog(ReminderEditActivity.this,mDateSetListener,mYear,mMonth,mDay);
        dateDialog.show();
    }
	
	private void updateDateButtonText() { 
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT); 
		String dateForButton = dateFormat.format(c.getTime()); 
		mDateButton.setText(dateForButton); 
		}

	
	public void onTime(View v)
	{
		mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        
        TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
         
          public void onTimeSet(TimePicker view, int hourOfDay, int minute)
          {
        	  
        	 //mHour = hourOfDay;
        	 // mMinute = minute;
        	 // mTimeDisplay.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
        	  c.set(Calendar.HOUR_OF_DAY, hourOfDay); 
        	  c.set(Calendar.MINUTE, minute);
        	  c.set(Calendar.SECOND, 0);
        	  c.set(Calendar.MILLISECOND, 0);
        	  updateTimeButtonText();
          }
        	
        };
    
        timeDialog = new TimePickerDialog(ReminderEditActivity.this, mTimeSetListener, mHour, mMinute, false);
        timeDialog.show();
		
	}
	
	private void updateTimeButtonText() {
		SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT); 
		String timeForButton = timeFormat.format(c.getTime()); 
		mTimeButton.setText(timeForButton); 
		
		}

	
	 public void onConfirm(View v) {
	    	onCreateDialog(0).show();
	    }
	    
	    
	    
	    	@Override
	    	protected Dialog onCreateDialog(int id) {
	        
	       
	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        
	        builder.setTitle("Warning!!!!!");
	        builder.setIcon(R.drawable.and_icon1);
	        builder.setMessage("Are you sure you want to save the task?")  ;
	        builder .setCancelable(false);  
	        builder .setPositiveButton("Yes", new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialog, int id) { 
	            	
	            	saveState(); 
	    			//setResult(RESULT_OK); 
	    			Toast.makeText(ReminderEditActivity.this,getString(R.string.task_saved_message),Toast.LENGTH_SHORT).show();
	    			
	            finish();  
	            }  
	        });  
	       builder .setNegativeButton("No", new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialog, int id) {  
	            //  Action for 'NO' Button  
	            dialog.cancel();  
	         }  
	        });  

	       return builder.create();  
	    
	    
	    }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reminder_edit, menu);
		return true;
	}

}
