package com.example.user1.csmobileappii;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiscussionForumFragment extends Fragment {

    FloatingActionButton raisePoint;

    public DiscussionForumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((MainActivity)getActivity()).setActionBarTitle("Discussion Forum");
         View myFragmentView = inflater.inflate(R.layout.fragment_discussion_forum, container, false);
        //return inflater.inflate(R.layout.fragment_discussion_forum, container, false);

        raisePoint = (FloatingActionButton) myFragmentView.findViewById(R.id.raiseDiscussionPoint);
        raisePoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(),RaiseDiscussionPointFormActivity .class);
                startActivity(i);
            }
        });



        return myFragmentView;
    }

}
