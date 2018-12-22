package com.example.intentimplicit;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText editText1=(EditText)findViewById(R.id.editText1);  
        Button button1=(Button)findViewById(R.id.button1);  
       
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                String url=editText1.getText().toString();  
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("tel:"+url));  
                startActivity(intent);                     //,Uri.parse("tel:9876557800"));
            }  
        });  
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
