package com.atid.app.atx.ReadJson;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LocationAdapter     {

    static float TrackingGPS_Longitude;
    static float TrackingGPS_Latitude;
    static String TrackingGPS_Time;
    static String TrackingGPS_Location="";
    private SimpleDateFormat simpleday = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


    public LocationAdapter() {

    }
    public LocationAdapter(float Longitude, float Latitude, String Time,String Location) {
        this.TrackingGPS_Longitude = Longitude;
        this.TrackingGPS_Latitude = Latitude;
        this.TrackingGPS_Time = Time;
        this.TrackingGPS_Location=Location;

    }

    public  float getTrackingGPS_Longitude() {
        return this.TrackingGPS_Longitude;
    }

    public  void setTrackingGPS_Longitude(float trackingGPS_Longitude) {
        TrackingGPS_Longitude = trackingGPS_Longitude;
    }

    public  float getTrackingGPS_Latitude() {
        return this.TrackingGPS_Latitude;
    }

    public  void setTrackingGPS_Latitude(float trackingGPS_Latitude) {
        TrackingGPS_Latitude = trackingGPS_Latitude;
    }

    public  String getTrackingGPS_Time() {
        return this.TrackingGPS_Time;
    }

    public  void setTrackingGPS_Time( ) {
         Calendar calNow = Calendar.getInstance();
         String dateT = simpleday.format(calNow.getTime());
        TrackingGPS_Time = dateT;
    }

    public  String getTrackingGPS_Location() {
        return this.TrackingGPS_Location;
    }

    public  void setTrackingGPS_Location(String trackingGPS_Location) {
        TrackingGPS_Location = trackingGPS_Location;
    }
}
