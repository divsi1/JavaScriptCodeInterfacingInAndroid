package com.example.testdeqode;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProgressActivity extends AppCompatActivity {

    ArrayList<JavaScriptResponse> responses;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_activity);
        ArrayList<String> responsesFromPreviousActivity =
                (ArrayList<String>) getIntent().getSerializableExtra("string_responses");
        for (int i = 0; i < responsesFromPreviousActivity.size(); i++) {
            String data = responsesFromPreviousActivity.get(i);
       if (data != null) {
                JavaScriptResponse javaScriptResponse = null;
                if (responses == null) {
                    responses = new ArrayList<JavaScriptResponse>();
                    try {
                        JSONObject myResponse = new JSONObject(data);
                        javaScriptResponse = new JavaScriptResponse();

                            javaScriptResponse.setId(myResponse.optInt("id"));
                            javaScriptResponse.setMessage(myResponse.optString("message"));
                            javaScriptResponse.setProgress(myResponse.optInt("progress"));
                            javaScriptResponse.setState(myResponse.optString("state"));
                            responses.add(javaScriptResponse);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        JSONObject myResponse = new JSONObject(data);
                        javaScriptResponse = new JavaScriptResponse();

                            javaScriptResponse.setId(myResponse.optInt("id"));
                            javaScriptResponse.setMessage(myResponse.optString("message"));
                            javaScriptResponse.setProgress(myResponse.optInt("progress"));
                            javaScriptResponse.setState(myResponse.optString("state"));
                            responses.add(javaScriptResponse);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        ListAdapter adapter = new ListAdapter(responses,ProgressActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ProgressActivity.this));
        recyclerView.setAdapter(adapter);
    }
}
