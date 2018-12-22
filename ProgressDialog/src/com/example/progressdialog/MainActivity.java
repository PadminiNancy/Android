package com.example.progressdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClick2(View v) {
    	//---show the dialog---
    	final ProgressDialog dialog = ProgressDialog.show(this, "Doing something", "Please wait...", true);
    	    	new Thread(new Runnable(){
    		public void run()
    		{
    			try {
    			//---simulate doing something lengthy---
    			  Thread.sleep(5000);
    			//---dismiss the dialog---
    			  
    			  dialog.dismiss();
    			 
    			 
    			} 
    			catch (Exception e) 
    			{
    			  e.printStackTrace();
    			}
    			

    	    }
    			}).start();
    	
    	
    	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
