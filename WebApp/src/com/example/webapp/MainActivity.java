package com.example.webapp;


import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
    public WebView myweb;
   // public ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        myweb =(WebView) findViewById(R.id.mywebview);
        myweb.getSettings().setJavaScriptEnabled(true);
       // myweb.setWebViewClient(new MyBrowser());
        //myweb.loadUrl("http://padmini/android_app/");//192.168.1.152
       // myweb.loadUrl("http://10.0.2.2/android_app/");
        myweb.loadUrl("http://10.0.2.2:6060/OnExSys");//
        //myweb.loadUrl("http://eds.net.in/");
        //myweb.setWebViewClient(new MyBrowserOverride());

    }

  /*  public class MyBrowserOverride extends WebViewClient implements com.example.webapp.MyBrowserOverride{

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);


        }

        @Override
        public boolean ShouldOverrideUrlLoading(WebView view, String Url){

            view.loadUrl(Url);
            return true;
        }


    }

    @Override
    public  boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if((keyCode==KeyEvent.KEYCODE_BACK) && myweb.canGoBack())
        {
            myweb.goBack();
            return  true;

        }
        return super.onKeyDown(keyCode,event);

    }

*/




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
