package com.example.alertdialogbox;

import android.os.Bundle;
import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	CharSequence[] items = {"Google","Apple","Microsoft"};
	boolean[] itemsChecked = new boolean [items.length];
	
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
    		builder.setIcon(R.drawable.and_img);
    		builder.setTitle("This is a dialog with some simple text...");
    		
    		builder.setPositiveButton("OK",new DialogInterface.OnClickListener() 
    		{
    		 public void onClick(DialogInterface dialog, int whichButton) 
    		 {
    		  Toast.makeText(getBaseContext(),"OK clicked!", Toast.LENGTH_SHORT).show();
    		 }
    	    }
    		);
    		
    		builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() 
    		{
    		 public void onClick(DialogInterface dialog, int whichButton) 
    		 {
    		  Toast.makeText(getBaseContext(),"Cancel clicked!", Toast.LENGTH_SHORT).show();
    		 }
    		}
    		);
    		
    		builder.setMultiChoiceItems(items, itemsChecked,new DialogInterface.OnMultiChoiceClickListener() 
    		{
    		 public void onClick(DialogInterface dialog,int which, boolean isChecked) 
    		 {
    		  Toast.makeText(getBaseContext(),
    		  items[which] + (isChecked ? " checked!":" unchecked!"),
    		  Toast.LENGTH_SHORT).show();
    		}
    		}
    	
    	);
    	return builder.create();
    	   
}   
    	   

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    	}
