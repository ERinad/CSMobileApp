package com.example.user1.csmobileappii.ApiInterface;

import com.example.user1.csmobileappii.Model.CheckID;
import com.example.user1.csmobileappii.Model.Login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user1 on 4/29/2018.
 */

public interface Login_Interface {

    @GET("login.php")
    Call<Login> login(@Query("user_name")String UserName, @Query("password") String Password);


}
