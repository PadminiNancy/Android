package com.example.spinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

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
        setContentView(R.layout.activity_main);
        
        Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, ss);
        s1.setAdapter(adapter);
        
        s1.setOnItemSelectedListener(new OnItemSelectedListener()
        {
         @Override
         public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
         {
        	 
          int index = arg0.getSelectedItemPosition();
          Toast.makeText(getBaseContext(), "You have selected item : " + ss[index],
          Toast.LENGTH_SHORT).show();
         }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) { }
        });
        }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
