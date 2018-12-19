package com.example.user1.csmobileappii.ApiClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user1 on 4/28/2018.
 */

public class ApiClient {

    public static final String BASE_URL="http://192.168.43.214:80/CS_Mobile_App/API/v1/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
    }


}
