package com.example.user1.csmobileappii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //Set action bar title
        getSupportActionBar().setTitle("Password Recovery");
    }
}
