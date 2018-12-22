package com.example.fragmentjava;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClick(View v)
    {
    	
    	MyJavaFrag frag = new MyJavaFrag();
    	android.app.FragmentManager manager = getFragmentManager(); 
    	android.app.FragmentTransaction transaction = manager.beginTransaction();
    	transaction.add(R.id.main_layout, frag,"MyFrag");
    	transaction.commit();
    	
    	
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
