package com.example.user1.csmobileappii;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //to display login page or home page which is news feeds







    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // login




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
         //navigate to Edit profile

        View headView=navigationView.getHeaderView(0);
        ImageView imageProfile=headView.findViewById(R.id.imageProfile);
        imageProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(i);
            }
        });



         //set the default home page as newsfeeds pager
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
       ft.replace(R.id.flmain,new NewsFragment());
       ft.commit();
       navigationView.setCheckedItem(R.id.nav_News);
    }

    public void setActionBarTitle(String title)
    {
     getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_News) {

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flmain,new NewsFragment());
        ft.commit();
        }
        else if (id == R.id.nav_noticeBoard) {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flmain,new NoticeBoardFragment());
            ft.commit();

        }else if (id == R.id.nav_discussionForum) {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flmain,new DiscussionForumFragment());
            ft.commit();

        } else if (id == R.id.nav_eventsAndCalander) {
           FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
           ft.replace(R.id.flmain,new EventsFragment());
           ft.commit();

//            Intent i=new Intent(MainActivity.this,EventsAndCalendarActivity.class);
//            startActivity(i);

        } else if (id == R.id.nav_courseInformation) {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flmain,new CourseInformationFragment());
            ft.commit();

        } else if (id == R.id.nav_users) {
            Intent i=new Intent(MainActivity.this,UsersActivity.class);
            startActivity(i);

        }else if(id == R.id.nav_settings){
            Intent i=new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(i);

        }else if (id==R.id.nav_help){
            Intent i=new Intent(MainActivity.this,HelpActivity.class);
            startActivity(i);
        }else if (id==R.id.nav_logout)
        {
            openAlertDialog();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Alert Dialog

    public void openAlertDialog()
    {
     AlertDialog.Builder alertDBuilder=new AlertDialog.Builder(this);
     alertDBuilder.setMessage("Are you sure ,you want to logout?");
     alertDBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
     {


         @Override
         public void onClick(DialogInterface arg0,int arg1)
         {
             Intent i=new Intent(getApplicationContext(),LoginActivity.class);
             startActivity(i);
         }
     });

     alertDBuilder.setNegativeButton("No",new DialogInterface.OnClickListener()
     {
        @Override
         public void onClick(DialogInterface arg0,int arg1)
        {
            Intent i=new Intent (getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
     });

     AlertDialog alertDialog=alertDBuilder.create();
     alertDBuilder.show();
    }
}
