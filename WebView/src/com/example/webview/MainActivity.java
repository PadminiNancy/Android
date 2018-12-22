package com.example.webview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {

	WebView w;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        w = (WebView) findViewById(R.id.webview);
       
        w.loadUrl("www.google.co.in");
        //w.loadData("http://localhost:10793/OnExSys/home.jsp", "text/html; charset=UTF-8",null);
       // w.loadUrl("http://localhost:10793/OnExSys/home.jsp");
    }

    

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
