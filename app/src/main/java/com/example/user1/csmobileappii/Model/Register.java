package com.example.user1.csmobileappii.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user1 on 4/29/2018.
 */

public class Register {

    @SerializedName("first_name")
    private String Fname;

    @SerializedName("last_name")
    private String Lname;

    @SerializedName("email")
    private String Email;

    @SerializedName("new_username")
    private String New_username;

    @SerializedName("new_password")
    private String New_password;



    @SerializedName("id_number")
    private String ID;

    @SerializedName("response")
    private  String Response;

    public void setFname(String fn)
    {
        this.Fname=fn;
    }

    public void setLname(String ln)
    {
        this.Lname=ln;
    }

    public void setEmail(String email)
    {
        this.Email=email;
    }

    public void setNew_username(String usr_nm)
    {
        this.New_username=usr_nm;
    }

    public void setNew_password(String pwd)
    {
        this.New_password=pwd;
    }


    public void setID(String id)
    {
        this.ID=id;
    }

    public String getResponse()
    {
        return Response;
    }

    public String getFname()
    {
        return Fname;
    }


}
