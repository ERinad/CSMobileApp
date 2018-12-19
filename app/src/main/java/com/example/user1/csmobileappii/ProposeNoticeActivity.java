package com.example.user1.csmobileappii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProposeNoticeActivity extends AppCompatActivity {

    String NoticeTitle;
    String NoticeContent;
    String ProposedBy;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propose_notice);

        //set action bar title
        getSupportActionBar().setTitle("Propose Notice");




    }
}
