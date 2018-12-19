package com.example.user1.csmobileappii;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    public static int time_out=4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //splash screen should be full screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash);






        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {


                 Intent i=new Intent(SplashActivity.this,LoginActivity.class);
                 startActivity(i);
                 finish();





            }


        },time_out);







    }
}
