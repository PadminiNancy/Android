package com.example.dialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
    }
    
    public void onClick(View v) {
    	onCreateDialog(0).show();
    }
    
    
    
    	@Override
    	protected Dialog onCreateDialog(int id) {
        
       
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        
        builder.setTitle("Warning!!!!!");
        builder.setIcon(R.drawable.and_icon1);
        builder.setMessage("Do you want to close this application ?")  ;
        builder .setCancelable(false);  
        builder .setPositiveButton("Yes", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialog, int id) {  
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
