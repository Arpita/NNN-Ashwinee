package com.ashwinee.videoapp.Utilities;


import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ashwinee on 02-Mar-19.
 */

public class Utility {

    String internetConnectionAndResponse(URL url){
        StringBuffer buffer=null;
        try{
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(12000);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Authorization","bearer b2918607b4301812914f5a5141c4d7da");
            urlConnection.connect();
            if(urlConnection.getResponseCode()== 200){
                buffer= new StringBuffer();
                BufferedReader bfReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String buff=null;
                while((buff=bfReader.readLine())!=null){
                    buffer.append(buff);
                }
            }
            urlConnection.disconnect();
        }catch(Exception e){
            Log.d("ERROR : ",e.getLocalizedMessage());
        }

        return buffer.toString();
    }
}

