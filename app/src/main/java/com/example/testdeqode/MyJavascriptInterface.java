package com.example.testdeqode;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import java.util.ArrayList;

public class MyJavascriptInterface {
    ArrayList<String>response=null;
    Context context;
    ArrayList<String> stringResponses;

    public MyJavascriptInterface(Context context) {
        this.context = context;
    }

    @android.webkit.JavascriptInterface
    public void getStringFromJS(String txtVal) {
        Toast.makeText(context, "Value From JS : " + txtVal, Toast.LENGTH_LONG).show();
        if(stringResponses==null)
        {
            stringResponses=new ArrayList<String>();
            stringResponses.add(txtVal);
        }
        else
        {
            stringResponses.add(txtVal);
        }
    }

    @android.webkit.JavascriptInterface
    public void startActivityFromJS() {

              Intent myIntent = new Intent(context, ProgressActivity.class);
              myIntent.putExtra("string_responses",stringResponses);
              context.startActivity(myIntent);
    }
}