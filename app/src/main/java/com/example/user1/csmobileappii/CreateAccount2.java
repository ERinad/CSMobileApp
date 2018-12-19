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
import android.widget.Toast;

import com.example.user1.csmobileappii.ApiClient.ApiClient;
import com.example.user1.csmobileappii.ApiInterface.CheckId_Interface;
import com.example.user1.csmobileappii.ApiInterface.Registration_Interface;
import com.example.user1.csmobileappii.Model.CheckID;
import com.example.user1.csmobileappii.Model.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAccount2 extends AppCompatActivity {

    private Registration_Interface apiInterface;

    private EditText Fname,Lname,Email, username,password;
    private Button Register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account2);

        //Set action bar title
        getSupportActionBar().setTitle("Create account form");

        Fname=(EditText)findViewById(R.id.f_name);
        Lname=(EditText)findViewById(R.id.l_name);
        Email=(EditText)findViewById(R.id.email);
        username=(EditText)findViewById(R.id.user_name);
        password=(EditText)findViewById(R.id.pwd);

        Register=(Button)findViewById(R.id.registerF);

        Register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
              //form validation
                String fname=Fname.getText().toString();
                String lname=Lname.getText().toString();
                String email=Email.getText().toString();
                String Username=username.getText().toString();
                String Password=password.getText().toString();
                String Id=CreateAccount1.id_no;

                if(fname.length()==0 || lname.length()==0 || email.length()==0 || Username.length()==0 || Password.length()==0 )
                {
                    String message="No Field can not be left Empty!";
                    openAlertDialog(message);
                }
                else
                {
                    if(isNetworkAvailable(getApplicationContext()))
                    {
                        performRegistration(fname,lname,email,Username,Password,Id);
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

// api call for registration
    public void performRegistration(String fn,String ln,String email, String Username, String Password,String id)
    {
        apiInterface= ApiClient.getApiClient().create(Registration_Interface.class);
        Call<Register> call=apiInterface.register(fn,ln,id,email,Username,Password);

        call.enqueue(new Callback<com.example.user1.csmobileappii.Model.Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {

                if(response.isSuccessful())
                {
                    if(response.body().getResponse()=="OK")
                    {
                        String msg="Registration Successfull";
                        openAlertDialog(msg);

                        Intent i=new Intent(CreateAccount2.this,LoginActivity.class);
                        startActivity(i);
                    }

                }else
                {
                  String msg="Something went wrong";
                  openAlertDialog(msg);
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
               String msg="Server is down";
               openAlertDialog(msg);
            }
        });



    }
}
