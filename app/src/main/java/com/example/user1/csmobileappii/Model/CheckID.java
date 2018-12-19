package com.example.user1.csmobileappii.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user1 on 4/28/2018.
 */

public class CheckID {

    @SerializedName("response")
    private String Response;

    @SerializedName("ID")
    private String ID_number;

    @SerializedName("role")
    private String Role;

    public String getRole()
    {
        return Role;
    }


   public String getResponse()
   {
       return Response;
   }

    public void setID_number(String id)
    {
       this.ID_number=id;
    }





}
