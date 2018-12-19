package com.example.user1.csmobileappii.ApiInterface;

import com.example.user1.csmobileappii.Model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user1 on 5/1/2018.
 */

public interface Users_Interface {

    @GET("/users")
    Call<List<Users>> getUsers();
}
