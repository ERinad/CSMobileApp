package com.example.user1.csmobileappii.ApiInterface;

import com.example.user1.csmobileappii.Model.CheckID;
import com.example.user1.csmobileappii.Model.Register;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user1 on 4/29/2018.
 */

public interface Registration_Interface {

    @GET("Register.php")
    Call <Register>register(@Query("first_name") String Fname,@Query("last_name") String Lname, @Query("id_number") String ID,
                            @Query("email") String Email, @Query("new_username") String New_username,
                            @Query("new_password") String New_Password);



}
