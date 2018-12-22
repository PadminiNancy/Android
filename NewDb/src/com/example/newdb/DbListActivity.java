package com.example.newdb;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.LayoutInflater;

public class DbListActivity extends ExpandableListActivity{

	ListView l ;
	DbAdapter d;
	private ArrayList<String> parentItems = new ArrayList<String>();
	private ArrayList<Object> childItems = new ArrayList<Object>();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_db_list);
		
		
ExpandableListView expandableList = getExpandableListView(); // you can use (ExpandableListView) findViewById(R.id.list)
		
		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);

		setGroupParents();
		setChildData();

		MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);
		
		adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		expandableList.setAdapter(adapter);
		expandableList.setOnChildClickListener(this);
		
		 
		 
	       
		
	}
	
	public void setGroupParents() {
		
		d = new DbAdapter(this);
		 d.open();
		 Cursor c = d.getAllDetails();
		 String s[] = new String[c.getCount()];
		 int i =0;
		 if(c.moveToFirst())
		 {
			 do{
				 s[i]= c.getString(1);
				 i++;
			 }while(c.moveToNext());
			 
		 }
		
    for(int j=0;j<s.length;j++)
    {
		parentItems.add(s[j]);
		
    }
	}

	public void setChildData() {
		
		
		d = new DbAdapter(this);
		 d.open();
		 int i =0;
		 Cursor c = d.getAllDetails();
		 String s[] = new String[c.getCount()];
		 String roll[] = new String[c.getCount()];
		 String email[] = new String[c.getCount()];
		 
		 if(c.moveToFirst())
		 {
			 do{
				 s[i]= c.getString(1);
				 roll[i] = c.getString(0);
				 email[i] = c.getString(2);
				 i++;
			 }while(c.moveToNext());
			 
		 }
		
   for(int j=0;j<s.length;j++)
   {
		// Android
		ArrayList<String> child = new ArrayList<String>();
		child.add(roll[j]);
		child.add(s[j]);
		child.add(email[j]);
		childItems.add(child);
   }
		
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.db_list, menu);
		return true;
	}

}
