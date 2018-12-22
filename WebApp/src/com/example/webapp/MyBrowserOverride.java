package com.example.webapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public interface MyBrowserOverride {

    boolean ShouldOverrideUrlLoading(WebView view, String Url);

}
