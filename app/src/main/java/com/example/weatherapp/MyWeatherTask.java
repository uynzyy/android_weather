package com.example.weatherapp;

import android.os.AsyncTask;

import com.example.weatherapp.JSONClasses.JSONFetcher;
import com.example.weatherapp.JSONClasses.JSONParser;
import com.example.weatherapp.Models.FiveDays;


public class MyWeatherTask extends AsyncTask<String, Void, FiveDays> {
    private MyWeatherTaskListener mListener;

    public MyWeatherTask(MyWeatherTaskListener pListener){
        this.mListener = pListener;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        mListener.onMyWeatherTaskPreExecute();
    }

    @Override
    protected FiveDays doInBackground(String... strings){
        FiveDays fiveDays = null;

        //Fetch Weather
        String jsonStr = JSONFetcher.fetchData(strings[0]);

        //Parsing Weather
        if(jsonStr!=null){
            fiveDays = JSONParser.getMyWeather(jsonStr);
        }

        return fiveDays;
    }

    @Override
    protected void onPostExecute(FiveDays fiveDays){
        super.onPostExecute(fiveDays);
        mListener.onMyWeatherTaskPostExecute(fiveDays);
    }
}

interface MyWeatherTaskListener{
    void onMyWeatherTaskPreExecute();
    void onMyWeatherTaskPostExecute(FiveDays fiveDays);
}
