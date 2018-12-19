package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private String earthquakeurl;


    public EarthquakeLoader(Context context,String url) {
        super(context);
        this.earthquakeurl = url;
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {

        // Don't perform the request if there are no URLs, or the first URL is null.
        if (earthquakeurl == null) {
            return null;
        }

        List<Earthquake> result = QueryUtils.fetchEarthquakeData(earthquakeurl);
        return result;
    }
}
