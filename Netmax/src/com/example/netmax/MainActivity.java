package com.example.netmax;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;







import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText name,roll,cno,email;
	Button save;
	ProgressDialog dialog=null;
	HttpPost httppost;
	HttpClient httpclient;
	HttpResponse response;
	List<NameValuePair> nameValuePairs;
	StringBuffer buffer;
	ProgressBar progressBar;  
	
	TextView resu;
	
	String r,n,c,e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        
        onClickButton();
    }
    
   
    public void onClickButton()
	{
	
		roll = (EditText) findViewById(R.id.roll);
    	name = (EditText) findViewById(R.id.name);
    	cno = (EditText) findViewById(R.id.contact);
    	email = (EditText) findViewById(R.id.email);
    	resu = (TextView) findViewById(R.id.result);
    	save = (Button) findViewById(R.id.submit);
    	//save = (Button) findViewById(R.id.button1);
		
	
	save.setOnClickListener(new OnClickListener(){
		
		@Override
		public void onClick(View v)
		{
			//register();
		dialog=ProgressDialog.show(MainActivity.this, "Registering", "Saving Data...",true);
		
		new Thread(new Runnable(){
			
			
			public void run()
			{
				
			register();
			//Toast.makeText(getApplicationContext(), "y", Toast.LENGTH_SHORT).show();
			
			}
		}).start();
		
			
			
		}
		
		
	});
		
	}
    
    
    public  void register(){
       
    	 try{  
    		 //Intent i = new Intent(getApplicationContext(),SecActivity.class);
    		 //startActivity(i);
    		 
    		//Toast.makeText(getApplicationContext(), "working...", 1).show();
    		 //resu.setText("perfect");
             
	           httpclient=new DefaultHttpClient();
	            httppost= new HttpPost("http://10.0.2.2:8084/AndProj/RegServ"); // make sure the url is correct.
	            //add your data
	            nameValuePairs = new ArrayList<NameValuePair>(4);
	            // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar,
	            nameValuePairs.add(new BasicNameValuePair("jroll",roll.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
	            nameValuePairs.add(new BasicNameValuePair("jname",name.getText().toString().trim()));
	            nameValuePairs.add(new BasicNameValuePair("jcno",cno.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
	            nameValuePairs.add(new BasicNameValuePair("jemail",email.getText().toString().trim()));
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	            //Execute HTTP Post Request
	           // response=httpclient.execute(httppost);
	           
	            ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            final String respon = httpclient.execute(httppost, responseHandler);
	            //System.out.println("Response : " + response);
	            
	            
	            runOnUiThread(new Runnable() {
	                public void run() {
	                    //tv.setText("Response from PHP : " + response);
	                	//Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
	                	resu.setText(respon);
	                    dialog.dismiss();
	                }
	            });
	             
	            /*if(respon.equalsIgnoreCase("record saved")){
	                runOnUiThread(new Runnable() {
	                    public void run() {
	                        Toast.makeText(MainActivity.this,"Registration Success", Toast.LENGTH_SHORT).show();
	                       // Intent i = new Intent(getApplicationContext(),SecActivity.class);
	                        //startActivity(i);
	                    }
	                });
	                 
	                
	                
	                //startActivity(new Intent(MainActivity.this, UserPage.class));
	            }else{
	            	Toast.makeText(MainActivity.this,"Login UnSuccess", Toast.LENGTH_SHORT).show();               
	            }*/
	             
	        }catch(Exception e){
	            dialog.dismiss();
	            System.out.println("Exception : " + e.getMessage());
	        }
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
