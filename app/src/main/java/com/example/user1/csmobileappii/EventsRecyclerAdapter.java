package com.example.user1.csmobileappii;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user1.csmobileappii.Model.Events;

import java.util.List;

/**
 * Created by user1 on 5/2/2018.
 */

public class EventsRecyclerAdapter extends RecyclerView.Adapter<EventsRecyclerAdapter.EventsViewHolder> {

      private List<Events> events;

       public EventsRecyclerAdapter(List<Events> events)
        {
        this.events=events;
        }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row,parent,false);

        return new EventsRecyclerAdapter.EventsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        holder.event_title.setText(events.get(position).getEventTitle());
        holder.event_day.setText(events.get(position).getEventDay());
        holder.event_time.setText(events.get(position).getEventTime());
        holder.event_venue.setText(events.get(position).getEventVenue());



    }

    @Override
    public int getItemCount()
    {

           return events.size();
    }


   public class EventsViewHolder extends  RecyclerView.ViewHolder
    {
        TextView event_title,event_day,event_time,event_venue;

        public EventsViewHolder(View itemView) {
            super(itemView);

            event_title=(TextView)itemView.findViewById(R.id.event_title);
            event_day=(TextView)itemView.findViewById(R.id.event_day);
            event_time=(TextView)itemView.findViewById(R.id.event_time);
            event_venue=(TextView)itemView.findViewById(R.id.event_venue);

        }
    }
}
