package com.example.user1.csmobileappii.ApiInterface;

import com.example.user1.csmobileappii.Model.CheckID;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by user1 on 4/28/2018.
 */

public interface CheckId_Interface {

    @GET("checkID.php")
   Call <CheckID>check_id(@Query("identification_number") String ID_number);




}
