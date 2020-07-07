 package com.example.testdeqode;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.ArrayList;
//dummy data
//{
//"id": String,
//"message": String,
//"progress": Number, // optional, depending on the value of message
//"state": String // optional, depending on the value of message
//}

 public class MainActivity extends AppCompatActivity{
     ArrayList<JavaScriptResponse> jsonResponses=null;
     WebView webView;
     String myResourceURL;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.my_web_view);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
         myResourceURL="file:///android_asset/demo.html";
        webView.loadUrl("file:///android_asset/demo.html");
        webView.addJavascriptInterface(new
                MyJavascriptInterface(this),
                "myOwnJSHandler");
    }
 }