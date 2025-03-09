package ru.valentin3131.taskmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    private List<User> users = new ArrayList<User>();

    public UserListAdapter(List<User> users) {this.users = users;};

    @Override
    public int getItemCount(){
        return users.size();
    }

    @NonNull
    @Override
    public UserListAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each task item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserListAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position){
        User user = users.get(position);
        holder.nameView.setText(user.getName());
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;

        public UserViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.userName_item);
        }
    }
}
