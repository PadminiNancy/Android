package com.example.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SecActivity extends ListActivity {

	String[] ss = {
			"Android",
			"Java",
			"Hibernate",
			"Spring",
			"Hadoop",
			"Perl",
			"Ruby",
			"Python",
			"Programming",
			"Networking",
			"Socket Programming"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_sec);
		
		setListAdapter(new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, ss));
	}

	public void onListItemClick(
    		ListView parent, View v, int position, long id)
    		{
    		Toast.makeText(this,
    		"You have selected " + ss[position],
    		Toast.LENGTH_SHORT).show();
    		}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sec, menu);
		return true;
	}

}
