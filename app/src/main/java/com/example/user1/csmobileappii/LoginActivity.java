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
import com.example.user1.csmobileappii.ApiInterface.Login_Interface;
import com.example.user1.csmobileappii.Model.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public static  String firstName;
    public static String  userRole;

    TextView createAccount;
    TextView forgotPwd;
    Button login;

    EditText un_name;
    EditText pwd;

    String Username;
    String Password;

    private Login_Interface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_login);


        un_name=(EditText)findViewById(R.id.usernm);
        pwd=(EditText)findViewById(R.id.login_pwd);


        //navigate to create account

        createAccount=(TextView)findViewById(R.id.textView3);
        createAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

                Intent i=new Intent(LoginActivity.this,CreateAccount1.class);
                startActivity(i);
            }

        });



        //navigate to Password Recovery
        forgotPwd=(TextView)findViewById(R.id.textForgot);
        forgotPwd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(i);
            }
        });

        //Authentication and navigate to home page

        login=(Button)findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

                Username=un_name.getText().toString();
                Password=pwd.getText().toString();

                if(Username.length()==0 || Password.length()==0)
                {
                    String msg="No field cannot be left Empty!";
                    openAlertDialog(msg);
                }
                else
                {
                    if(isNetworkAvailable(getApplicationContext()))
                    {
                        perform_Login(Username,Password);
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

    //check for internet connection
    public static boolean isNetworkAvailable(Context context)
    {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

//login api call
    public void perform_Login(String un,String passwd)
    {
       apiInterface= ApiClient.getApiClient().create(Login_Interface.class);
       Call<Login> call=apiInterface.login(un,passwd);

       call.enqueue(new Callback<Login>() {
           @Override
           public void onResponse(Call<Login> call, Response<Login> response) {

             if(response.isSuccessful())
             {
               if(response.body().getStatus().toString().equals("OK"))
               {
                   firstName=response.body().getFirstname().toString();
                   userRole=response.body().getRole().toString();

                   Intent i=new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(i);
               }
               else
               {
                   String msg="Invalid Username-Password combination";
                   openAlertDialog(msg);
               }
             }
             else
             {
                 String m="API error";
                 openAlertDialog(m);
             }

           }

           @Override
           public void onFailure(Call<Login> call, Throwable t) {
               String msg="Server is down.";
               openAlertDialog(msg);

           }
       });


    }

}
