package com.example.user1.csmobileappii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UsersDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_detail);

        //set action bar title
        getSupportActionBar().setTitle("User Profile");
    }
}
