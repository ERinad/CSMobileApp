package com.example.user1.csmobileappii.Model;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user1 on 5/1/2018.
 */

public class Users {

    @SerializedName("Fname")
    private String First_name;

    @SerializedName("Lname")
    private String Last_name;

    //@SerializedName(" ")
    //private  Image UserImage;

//    public Image getUserImage()
//   {
//     return  UserImage;
//   }

    public String getFirst_name()
    {
        return  First_name;
    }

    public  String getLast_name()
    {
        return Last_name;
    }



}
