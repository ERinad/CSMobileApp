package com.example.user1.csmobileappii;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProposeNewsActivity extends AppCompatActivity {

    String NewsTitle;
    String NewsDescription;
    String NewsSource;
    String ProposedBy;
    Button SubmitNews;

    TextView RequiredFieldMsg;

    EditText news_title;
    EditText news_description;
    EditText news_source;
    EditText proposed_by;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propose_news);

        //Set action bar title
        getSupportActionBar().setTitle("Propose News");

        //
        news_title=(EditText)findViewById(R.id.news_title);
        news_description=(EditText)findViewById(R.id.news_desription);
        news_source=(EditText)findViewById(R.id.news_source);
        proposed_by=(EditText)findViewById(R.id.proposed_by);

        RequiredFieldMsg=(TextView)findViewById(R.id.required_field_PN);

        SubmitNews=(Button)findViewById(R.id.submit_news_btn);
        SubmitNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsTitle=news_title.getText().toString();
                NewsDescription=news_description.getText().toString();
                NewsSource=news_source.getText().toString();
                ProposedBy=proposed_by.getText().toString();

                if(NewsTitle.length()==0)
                {
                    openAlertDialog();
                    RequiredFieldMsg.setText("News title can not be left Empty");
                }
                else if (NewsDescription.length()==0)
                {
                    openAlertDialog();
                    RequiredFieldMsg.setText("News description field can not be left Empty");
                }
                else if(NewsSource.length()==0)
                {
                    openAlertDialog();
                    RequiredFieldMsg.setText("News Source can not be left Empty");
                }
                else if(proposed_by.length()==0)
                {
                    openAlertDialog();
                    RequiredFieldMsg.setText("Proposed by field can not be left Empty");
                }


            }
        });


    }

    //Alert Dialog

    public void openAlertDialog()
    {
        AlertDialog.Builder alertDBuilder=new AlertDialog.Builder(this);
        alertDBuilder.setMessage("No field should be left Empty!");
        alertDBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface arg0,int arg1)
            {

            }
        });

        AlertDialog alertDialog=alertDBuilder.create();
        alertDBuilder.show();
    }
    //Alert dialog ends here
}

