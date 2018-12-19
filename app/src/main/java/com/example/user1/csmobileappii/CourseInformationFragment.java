package com.example.user1.csmobileappii;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CourseInformationFragment extends Fragment {

    public CardView yearOne,yearTwo,yearThree,yearFour;

    public CourseInformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((MainActivity)getActivity()).setActionBarTitle("Course Information");
        View view =inflater.inflate(R.layout.fragment_course_information, container, false);

        yearOne=(CardView)view.findViewById(R.id.year1);
        yearTwo=(CardView)view.findViewById(R.id.year2);
        yearThree=(CardView)view.findViewById(R.id.year3);
        yearFour=(CardView)view.findViewById(R.id.year4);


        yearOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
             Intent i=new Intent(getActivity(),YearOneActivity.class);
             startActivity(i);
            }

        });

        yearTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(getActivity(),yearTwoActivity.class);
                startActivity(i);
            }

        });

        yearThree.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(getActivity(),YearThreeActivity.class);
                startActivity(i);
            }

        });

        yearFour.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(getActivity(),YearFourActivity.class);
                startActivity(i);
            }

        });






        return view;
    }

}
