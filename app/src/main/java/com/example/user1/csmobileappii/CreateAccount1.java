package com.example.user1.csmobileappii;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user1.csmobileappii.ApiClient.ApiClient;
import com.example.user1.csmobileappii.ApiInterface.CheckId_Interface;
import com.example.user1.csmobileappii.Model.CheckID;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAccount1 extends AppCompatActivity {

    EditText Id_number;
    Button submitId;

    String id_num;
    String status;

    private String  result;
    private CheckId_Interface apiInterface;
    public static String id_no;
    private String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account1);

        //Set action bar title
        getSupportActionBar().setTitle("Sign up");

        Id_number=(EditText)findViewById(R.id.id_nunmber);


        submitId= (Button) findViewById(R.id.submitId);
        submitId.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                id_num=Id_number.getText().toString();
                if(id_num.length()==0)
                {
                    String message="Identification number field can not be left Empty!";
                    openAlertDialog(message);
                }
                else
                {

                    if(isNetworkAvailable(getApplicationContext()))
                    {
                        ApiInterface(id_num);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                    }


                }


            }

        });


    }

    //Alert Dialog

    public void openAlertDialog(String message)
    {
        AlertDialog.Builder alertDBuilder=new AlertDialog.Builder(this);
        alertDBuilder.setMessage(message);
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

    ///If network is available or not


    public static boolean isNetworkAvailable(Context context)
    {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }
    //for sending id value to api and get response
    public void ApiInterface(String id)
    {

        apiInterface= ApiClient.getApiClient().create(CheckId_Interface.class);
        Call <CheckID> call=apiInterface.check_id(id);

        call.enqueue(new Callback<CheckID>() {
            @Override
            public void onResponse(Call<CheckID> call, Response<CheckID> response) {

                String message="works still here";
                openAlertDialog(message);
                if(response.isSuccessful())
                {
                    if(response.body().getResponse().equals("OK"))
                    {
                         id_no=id;

                        Intent i=new Intent(CreateAccount1.this,CreateAccount2.class);
                        startActivity(i);

                    }
                    else
                    {
                        String message1=response.body().getResponse();
                        openAlertDialog(message1);
                    }
                }
                else
                {
                    String message2="Server not responding.";
                    openAlertDialog(message2);
                }


            }

            @Override
            public void onFailure(Call<CheckID> call, Throwable t) {

                String message="Server is down. ";
                openAlertDialog(message);
            }
        });
          /////


    }

    //pass values to CreateAccount2 activity



}
