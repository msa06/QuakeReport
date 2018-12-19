package com.example.android.quakereport;



public class Earthquake {
    private double mMagnitude;
    private String mPlace;
    private long mTimeInMiliseconds;
    private String mURL;

    public Earthquake(double mMagnitude, String mPlace, long mTimeInMiliseconds,String mURL) {
        this.mMagnitude = mMagnitude;
        this.mPlace = mPlace;
        this.mTimeInMiliseconds = mTimeInMiliseconds;
        this.mURL = mURL;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getmPlace() {
        return mPlace;
    }

    public void setmPlace(String mPlace) {
        this.mPlace = mPlace;
    }

    public long getmTimeInMiliseconds() {
        return mTimeInMiliseconds;
    }

    public void setmTimeInMiliseconds(long mTimeInMiliseconds) {
        this.mTimeInMiliseconds = mTimeInMiliseconds;
    }

    public String getmURL() {
        return mURL;
    }
}
