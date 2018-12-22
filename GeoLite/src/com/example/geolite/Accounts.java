package com.example.geolite;


import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class Accounts extends ListActivity {

	DbAdapter db;
	String row[], p[],d[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_accounts);
		
		db = new DbAdapter(this);
		fillData();
		registerForContextMenu(getListView());
	}
	
	public void fillData()
	{
		db.open();
		Cursor c = db.getAllDetails();
		d= new String[c.getCount()];
		row = new String[c.getCount()];
		p = new String[c.getCount()];
		int i=0;
		if(c.moveToFirst())
		{
			do{
				row[i] = c.getString(0);
				d[i] = c.getString(1);
				p[i] = c.getString(2);
				i++;
				
			}while(c.moveToNext());
			
			
		}
		db.close();
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, d));
	}
	
	@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        
        //getMenuInflater().inflate(R.menu.reminder_list, menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.context, menu);
    }

	@Override
    public boolean onContextItemSelected(MenuItem item) { 
    	
       AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
       switch(item.getItemId()) { 
          case R.id.menu_delete: 
         	 db.open();
        	 boolean check = db.deleteReminder(Long.parseLong(row[info.position]));
        	 if(check)
        	  Toast.makeText(getApplicationContext(),"Task Deleted Successfully!!!",Toast.LENGTH_LONG).show();
        	 else
        	 Toast.makeText(getApplicationContext(),"Deletion Failed!!!",Toast.LENGTH_LONG).show();         		 
            fillData(); 
           
           return true;
    }
    return super.onContextItemSelected(item);
    }
	
	@Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
      //  Toast.makeText(getApplicationContext(), Integer.toString(position), 1).show();
       Intent i = new Intent(getApplicationContext(),Password.class);
        i.putExtra("name", d[position]);
        i.putExtra("pass", p[position]);
        i.putExtra("row", row[position]);
        startActivity(i);        
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accounts, menu);
		return true;
	}
	
	 public boolean onOptionsItemSelected(MenuItem item) {  
	        switch (item.getItemId()) {  
	            case R.id.menu :
	            
	            	Intent i = new Intent(getApplicationContext(),SetPassword.class);
	                startActivity(i);
	            	return true;                   
	              default:  
	                return super.onOptionsItemSelected(item);  
	        }
	    }

}
