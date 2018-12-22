package com.example.sophisticatedprogressdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button b;
	ProgressDialog progressDialog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b = (Button) findViewById(R.id.button1);
                
    }
    
    public void onClick(View v)
    {
    
    	showDialog(1);
    	
    	progressDialog.setProgress(0);
    	progressDialog.setProgress(0);
    	new Thread(new Runnable(){
    	public void run(){
    	for (int i=1; i<=15; i++) {
    	try {
    	//---simulate doing something lengthy---
    	Thread.sleep(1000);
    	//---update the dialog---
    	progressDialog.incrementProgressBy((int)(100/15));
    	} catch (InterruptedException e) {
    	e.printStackTrace();
    	}
    	}
    	progressDialog.dismiss();
    	}
    	}).start();
    	
    	
    }
    
    protected Dialog onCreateDialog(int id) {
		
    	progressDialog = new ProgressDialog(this);
    	progressDialog.setIcon(R.drawable.ic_launcher);
    	progressDialog.setTitle("Downloading files...");
    	progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    	progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
    	new DialogInterface.OnClickListener() {
    	public void onClick(DialogInterface dialog,
    	int whichButton)
    	{
    		Toast.makeText(getBaseContext(),"OK clicked!", Toast.LENGTH_SHORT).show();
    		}
    		});
    		progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
    		new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog,
    		int whichButton)
    		{
    		Toast.makeText(getBaseContext(),
    		"Cancel clicked!", Toast.LENGTH_SHORT).show();
    		}
    		});
    		return progressDialog;
    		
    		
    	
    	
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
