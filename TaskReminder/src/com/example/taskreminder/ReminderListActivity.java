package com.example.taskreminder;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.ListActivity;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ReminderListActivity extends ListActivity {

	int ACTIVITY_EDIT = 0;
	String row[];
	RemindersDbAdapter mDbHelper;
	  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_list);   
        mDbHelper = new RemindersDbAdapter(this);
       fillData();
      registerForContextMenu(getListView());
    }
     private void fillData() {
    	 mDbHelper.open();
         Cursor c = mDbHelper.fetchAllReminders();
         String r[] = new String[c.getCount()];
         row=new String[c.getCount()];
         int i = 0;
 		if(c.moveToFirst())
     	{
     	do{
     			row[i]=c.getString(0);
       			r[i] = c.getString(1);
       			i++;
     		}while(c.moveToNext());
     	}
 		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, r));
 		mDbHelper.close(); 	
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
       Intent i = new Intent(getApplicationContext(),RemindersUpActivity.class);
        i.putExtra("key", row[position]); 
        startActivityForResult(i, ACTIVITY_EDIT);        
    }
 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater mi = getMenuInflater();
       mi.inflate(R.menu.reminder_list, menu);
        return true;
        }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        
        //getMenuInflater().inflate(R.menu.reminder_list, menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.list_longress, menu);
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) { 
        switch(item.getItemId()) { 
        case R.id.menu_insert: 
        createReminder(); 
        return true; 
      }
        return super.onMenuItemSelected(featureId, item);
    }
    
    private static final int ACTIVITY_CREATE=0;
   
    private void createReminder() {
           Intent i = new Intent(this, ReminderEditActivity.class);
           startActivityForResult(i, ACTIVITY_CREATE);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
      super.onActivityResult(requestCode, resultCode, intent);
      // Reload the list here
      fillData();
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) { 
    	
       AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
       switch(item.getItemId()) { 
          case R.id.menu_delete: 
         	 mDbHelper.open();
        	 boolean check = mDbHelper.deleteReminder(Long.parseLong(row[info.position]));
        	 if(check)
        	  Toast.makeText(getApplicationContext(),"Task Deleted Successfully!!!",Toast.LENGTH_LONG).show();
        	 else
        	 Toast.makeText(getApplicationContext(),"Deletion Failed!!!",Toast.LENGTH_LONG).show();         		 
            fillData();
           return true;
    }
    return super.onContextItemSelected(item);
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {  
        switch (item.getItemId()) {  
            case R.id.menu_insert:  
            	Intent i = new Intent(getApplicationContext(),ReminderEditActivity.class);
                startActivity(i);
            	return true;                   
              default:  
                return super.onOptionsItemSelected(item);  
        }
    }
}
