package com.example.user1.csmobileappii;


import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user1.csmobileappii.ApiClient.ApiClient;
import com.example.user1.csmobileappii.ApiClient.ApiClient2;
import com.example.user1.csmobileappii.ApiInterface.Events_Interface;
import com.example.user1.csmobileappii.ApiInterface.Users_Interface;
import com.example.user1.csmobileappii.Model.Events;
import com.example.user1.csmobileappii.Model.Users;

import java.io.Console;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private EventsRecyclerAdapter adapter;
    private List<Events> events;
    private Events_Interface apiInterface;


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).setActionBarTitle("Events and Calendar");
        View view=inflater.inflate(R.layout.fragment_events, container, false);



        if(isNetworkAvailable(getActivity().getApplicationContext()))
        {
            loadEvents();

            recyclerView=(RecyclerView)view.findViewById(R.id.events_recyclerView);

            layoutManager=new LinearLayoutManager(getActivity());


            recyclerView.setLayoutManager(layoutManager);
            String msg="in the reponse ca";
            openAlertDialog(msg);
            recyclerView.setHasFixedSize(true);
        }
        else
        {
            Toast.makeText(getActivity().getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }



        return view;
    }




    //check for internet connection
    public static boolean isNetworkAvailable(Context context)
    {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }


    //performs events api call
    public void loadEvents()
     {

    apiInterface= ApiClient2.getApiClient().create(Events_Interface.class);
    Call<List<Events>> call=apiInterface.getEvents();

    call.enqueue(new Callback<List<Events>>() {

        @Override
        public void onResponse(Call<List<Events>> call, Response<List<Events>> response) {


            events=response.body();

            for(Events e:events ){
                Log.d( "Event_title",e.getEventTitle().toString());
            }



            adapter=new EventsRecyclerAdapter(events);
            recyclerView.setAdapter(adapter);

        }

        @Override
        public void onFailure(Call<List<Events>> call, Throwable t) {

          String msg="something went wrong";
          openAlertDialog(msg);


        }
    });


}

    //Alert Dialog

    public void openAlertDialog(String message)
    {
        AlertDialog.Builder alertDBuilder=new AlertDialog.Builder(getActivity());
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

}
