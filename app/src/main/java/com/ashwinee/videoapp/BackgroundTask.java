package com.ashwinee.videoapp;

import android.os.AsyncTask;

import com.ashwinee.videoapp.Interfaces.AsyncTaskMainCallback;

import java.net.URL;

/**
 * Created by Ashwinee on 02-Mar-19.
 */

public class BackgroundTask extends  AsyncTask<URL, Integer, String>{

    AsyncTaskMainCallback asyncTaskMainCallback;

    public BackgroundTask( AsyncTaskMainCallback asyncTaskMainCallback){
        this.asyncTaskMainCallback=asyncTaskMainCallback;
    }

    @Override
    protected String doInBackground(URL... params) {

        String result=
        return null;
    }

    protected void onPostExecute(String result) {
        asyncTaskMainCallback.returnToMainWithResult(result);
    }
}
