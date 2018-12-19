package com.example.user1.csmobileappii;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user1.csmobileappii.ApiClient.ApiClient;
import com.example.user1.csmobileappii.ApiClient.ApiClient2;
import com.example.user1.csmobileappii.ApiInterface.Users_Interface;
import com.example.user1.csmobileappii.Model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {

     private RecyclerView recyclerView;
     private RecyclerView.LayoutManager layoutManager;
     private UserRecyclerAdapter adapter;
     private List<Users> users;
     private Users_Interface apiInterface;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        //set action bar title
        getSupportActionBar().setTitle("Users");


        if(isNetworkAvailable(getApplicationContext()))
        {
            loadUsers();

            recyclerView=(RecyclerView)findViewById(R.id.user_recyclerView);
            layoutManager=new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);


        }
        else
        {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }





    }


    //check for internet connection
    public static boolean isNetworkAvailable(Context context)
    {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }


    //call user api
    public void loadUsers()
    {
        apiInterface= ApiClient2.getApiClient().create(Users_Interface.class);
        Call <List<Users>> call=apiInterface.getUsers();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                users=response.body();
                adapter=new UserRecyclerAdapter(users);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });
    }
}
