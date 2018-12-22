package com.example.web_reg;


import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;








import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends Activity{
	
	Button BtnSubmit;
	//EditText sname,scourse,doa,cno,email;
	EditText name,roll,cno,email;
	Button save;
	
	HttpPost httppost;
	HttpClient httpclient;
	HttpResponse response;
	List<NameValuePair> nameValuePairs;
	StringBuffer buffer;
	ProgressDialog dialog=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		onClickButton();
	}

	public void onClickButton()
	{
	
	/*sname=(EditText)findViewById(R.id.editText1);
    scourse=(EditText)findViewById(R.id.editText2);
    doa=(EditText)findViewById(R.id.editText3);
    cno=(EditText)findViewById(R.id.editText4);
    email=(EditText)findViewById(R.id.editText5);
	
	BtnSubmit=(Button)findViewById(R.id.button1);*/
		
		roll = (EditText) findViewById(R.id.editText1);
    	name = (EditText) findViewById(R.id.editText2);
    	cno = (EditText) findViewById(R.id.editText4);
    	email = (EditText) findViewById(R.id.editText5);
    	save = (Button) findViewById(R.id.button1);
		
	
	save.setOnClickListener(new OnClickListener(){
		
		@Override
		public void onClick(View v)
		{
			
		dialog=ProgressDialog.show(MainActivity.this, "Registering", "Saving Data...",true);
		
		/*new Thread(new Runnable(){
			
			
			public void run()
			{*/
				
			register();
			Toast.makeText(getApplicationContext(), "y", Toast.LENGTH_SHORT).show();
			
			//}
		//}).start();
		
			
			
		}
		
		
	});
		
	}
	
	
	public  void register(){
	        try{           
	              
	        	Toast.makeText(getApplicationContext(), "y1", Toast.LENGTH_SHORT).show();
	            httpclient=new DefaultHttpClient();
	            Toast.makeText(getApplicationContext(), "y2", Toast.LENGTH_SHORT).show();
	            HttpPost httpPost=new HttpPost("http://eds.net.in/index.php"); 
	            Toast.makeText(getApplicationContext(), "y3", Toast.LENGTH_SHORT).show();

	           // httppost= new HttpPost("http://app.jbvnl.co.in/reg.php"); // make sure the url is correct.
	            //add your data
	            nameValuePairs = new ArrayList<NameValuePair>(4);
	            // Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar,
	            /*nameValuePairs.add(new BasicNameValuePair("txtname",sname.getText().toString().trim()));  // $Edittext_value = $_POST['Edittext_value'];
	            nameValuePairs.add(new BasicNameValuePair("txtcourse",scourse.getText().toString().trim()));
	            nameValuePairs.add(new BasicNameValuePair("txtdoa",doa.getText().toString().trim()));
	            nameValuePairs.add(new BasicNameValuePair("txtcno",cno.getText().toString().trim()));
	            nameValuePairs.add(new BasicNameValuePair("txtmail",email.getText().toString().trim()));*/
	            
	            nameValuePairs.add(new BasicNameValuePair("jroll",roll.getText().toString().trim()));
	            nameValuePairs.add(new BasicNameValuePair("jname",name.getText().toString().trim()));
	            nameValuePairs.add(new BasicNameValuePair("jcno",cno.getText().toString().trim()));
	            nameValuePairs.add(new BasicNameValuePair("jemail",email.getText().toString().trim()));
	            
	            Toast.makeText(getApplicationContext(), "y4", Toast.LENGTH_SHORT).show();
	            
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	            
	            Toast.makeText(getApplicationContext(), "y5", Toast.LENGTH_SHORT).show();
	            //Execute HTTP Post Request
	           // response=httpclient.execute(httppost);
	           
	            ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            
	            Toast.makeText(getApplicationContext(), "y6", Toast.LENGTH_SHORT).show();
	            final String response = httpclient.execute(httppost, responseHandler);
	            Toast.makeText(getApplicationContext(), "y7", Toast.LENGTH_SHORT).show();
	            //System.out.println("Response : " + response);
	            
	            
	            runOnUiThread(new Runnable() {
	                public void run() {
	                    //tv.setText("Response from PHP : " + response);
	                	Toast.makeText(getApplicationContext(), "y8", Toast.LENGTH_SHORT).show();
	                	Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
	                    dialog.dismiss();
	                }
	            });
	             
	            if(response.equalsIgnoreCase("User Found")){
	                runOnUiThread(new Runnable() {
	                    public void run() {
	                        Toast.makeText(MainActivity.this,"Registartion Success", Toast.LENGTH_SHORT).show();
	                    }
	                });
	                 
	                
	                
	                //startActivity(new Intent(MainActivity.this, UserPage.class));
	            }else{
	            	Toast.makeText(MainActivity.this,"Registartion Failed", Toast.LENGTH_SHORT).show();               
	            }
	             
	        }catch(Exception e){
	        	
	            dialog.dismiss();
	            Toast.makeText(getApplicationContext(), "y9", Toast.LENGTH_SHORT).show();
	            System.out.println("Exception : " + e.toString());
	            
	        }
	    }
}
