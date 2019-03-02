package com.ashwinee.videoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ashwinee.videoapp.Interfaces.AsyncTaskMainCallback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AsyncTaskMainCallback {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> items;

    private final String siteAddress="https://api.vimeo.com/categories";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getHold();
    }

    public void hit_Url(View view) {
        URL url=null;

        try{
            url =new URL(siteAddress);
        }catch(Exception e){
            Log.d("ERROR : ",e.getLocalizedMessage());
        }
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(url);
    }

    private void getHold(){
        listView=(ListView)findViewById(R.id.list_view);
    }


    @Override
    public void returnToMainWithResult(String result) {
            //parse and set to List<> and then set the adapter:
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }
}
