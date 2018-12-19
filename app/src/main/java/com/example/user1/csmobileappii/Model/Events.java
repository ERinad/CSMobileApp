package com.example.user1.csmobileappii.Model;

import android.util.EventLog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user1 on 5/2/2018.
 */

public class Events {


    @SerializedName("Event_title")
    private String EventTitle;

    @SerializedName("Event_day")
    private String EventDay;

    @SerializedName("Event_time")
    private String EventTime;

    @SerializedName("Event_venue")
    private String EventVenue;

    public String getEventTitle()
    {
        return EventTitle;
    }

    public String getEventDay()
    {
        return  EventDay;
    }

    public  String getEventTime()
    {
        return  EventTime;
    }

    public  String getEventVenue()
    {
        return EventVenue;
    }





}
