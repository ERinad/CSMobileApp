package com.example.user1.csmobileappii.ApiInterface;

import com.example.user1.csmobileappii.Model.CheckID;
import com.example.user1.csmobileappii.Model.Events;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user1 on 5/2/2018.
 */

public interface Events_Interface {

    @GET("/events")
    Call<List<Events>>  getEvents();

}
