package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPERATOR = " of ";
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context,0,earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemview  = convertView;
        if(listitemview==null){
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Earthquake earthquake = getItem(position);

        //Format Decimal
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitude = formatter.format(earthquake.getmMagnitude());
        TextView magnitudetext = (TextView) listitemview.findViewById(R.id.magnitude);
        magnitudetext.setText(magnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudetext.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);



        //Place Different Text
        String originalLocation = earthquake.getmPlace();
        String locationOffset,primaryLocation;

        if(originalLocation.contains(LOCATION_SEPERATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPERATOR);
            locationOffset = parts[0] + LOCATION_SEPERATOR;
            primaryLocation = parts[1];
        }else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView primaryLocText = (TextView) listitemview.findViewById(R.id.primary_location);
        primaryLocText.setText(primaryLocation);

        TextView locationOffText = (TextView) listitemview.findViewById(R.id.location_offset);
        locationOffText.setText(locationOffset);



        //Set time
        TextView datetext = (TextView) listitemview.findViewById(R.id.date);
        TextView timetext = (TextView) listitemview.findViewById(R.id.time);

        //Change UniX Time to Standard TIme
        Date dateObj = new Date(earthquake.getmTimeInMiliseconds());
        String formattedDate = formatDate(dateObj);
        datetext.setText(formattedDate);

        String formattedTime = formatTime(dateObj);
        timetext.setText(formattedTime);

        return listitemview;
    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
