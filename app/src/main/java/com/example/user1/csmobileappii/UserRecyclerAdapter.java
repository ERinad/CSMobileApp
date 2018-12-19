package com.example.user1.csmobileappii;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user1.csmobileappii.Model.Users;

import java.util.List;

/**
 * Created by user1 on 5/1/2018.
 */

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UsersViewHolder>{


    private List<Users> users;

    public UserRecyclerAdapter(List<Users> users)

    {
        this.users=users;
    }


    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);

        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {


        holder.Firstname.setText(users.get(position).getFirst_name());
        holder.Lastname.setText(users.get(position).getLast_name());

    }

    @Override
    public int getItemCount()
    {
        return  users.size();
    }

   public class UsersViewHolder extends  RecyclerView.ViewHolder
    {
        TextView Firstname,Lastname;
        LinearLayout parentLayout;

        public UsersViewHolder(View itemView) {
            super(itemView);

            Firstname=(TextView)itemView.findViewById(R.id.user_first_name);
            Lastname=(TextView)itemView.findViewById(R.id.user_last_name);
            parentLayout=(LinearLayout)itemView.findViewById(R.id.parent_Layout);
        }
    }
}
