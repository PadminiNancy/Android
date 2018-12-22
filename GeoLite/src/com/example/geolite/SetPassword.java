package com.example.geolite;



import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SetPassword extends Activity {

 EditText uname, upass;	
 TextView result;
 String name,pass;
 DbAdapter db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_password);
		
		db = new DbAdapter(this);
		
		uname = (EditText) findViewById(R.id.name);
		upass = (EditText) findViewById(R.id.upass);
		result = (TextView) findViewById(R.id.encrpt);
	}
	
	public void onSubmit(View v)
	{
		
		name = uname.getText().toString();
		pass = upass.getText().toString();
		
		SharedPreferences sh = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        int diff = sh.getInt("diff", 0);
        int rev = sh.getInt("reverse", 0);
        
        if(diff > 0)
        {
        	
        	//String [] s = new String[50];
            String g = pass;
            pass ="";
            String en;
            int a=0,t=57,d=0;
            char m;
            for(int i=0;i<g.length();i++){

             a = g.charAt(i);
             
             if((a>64 && a<91)){
              
               if((a+diff)>=91){
                 d = (a+diff)-90;
                 pass = pass+((char)(64+d));
               }
               else
            	   pass = pass+((char)(a+diff));
             }
             else if(a>96 && a<123)
             {
                if((a+diff)>=123){
                    d = (a+diff)-122;
                    pass = pass+((char)(96+d));
                   
                }
                else
                	pass = pass+((char)(a+diff));
             }
             else if(a>47 && a<58){
                 m = g.charAt(i);

                 t = Character.digit(m, 10);
                 pass = pass+((t+diff)%10);
             }
             else
            	 pass = pass+(g.charAt(i));
            }
       
        	
        }
        
        if(rev==1)
        {
        	int j=0,i;
        	String reverse="";
        	for(i=pass.length()-1;i>=0;i--)
        	{
        		reverse= reverse+pass.charAt(i);        		
        	}
        	pass = reverse;
        }
        
        result.setText(pass);
        onCreateDialog(0).show();
		
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
    
   
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    
    builder.setTitle("Warning!!!!!");
    builder.setIcon(R.drawable.add);
    builder.setMessage("Do you want to save this task ?")  ;
    builder .setCancelable(false);  
    builder .setPositiveButton("Yes", new DialogInterface.OnClickListener() {  
        public void onClick(DialogInterface dialog, int id) {  
        
        	saveState();
        	Toast.makeText(getApplicationContext(), "Saved Successfully!!!!", 1).show();
        	Intent i = new Intent(getApplicationContext(),Accounts.class);
        	startActivity(i);
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
	
	public void saveState()
	{
		db.open();
		Long row = db.insertStud(name, pass);
		db.close();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set_password, menu);
		return true;
	}
	

}
