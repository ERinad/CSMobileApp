package com.example.user1.csmobileappii.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user1 on 4/29/2018.
 */

public class Login {

    @SerializedName("user_name")
    private String UserName;

    @SerializedName("password")
    private String Password;

    @SerializedName("first_name")
    private String Firstname;

    @SerializedName("role")
    private  String Role;

    @SerializedName("response")
    private String Status;



    public void setUserName(String un)
    {
        this.UserName=un;
    }

    public void setPassword(String pwd)
    {
        this.Password=pwd;
    }

    public String getRole()
    {
        return Role;
    }

    public String getFirstname()
    {
        return Firstname;
    }

    public String getStatus()
    {
        return  Status;
    }



}
