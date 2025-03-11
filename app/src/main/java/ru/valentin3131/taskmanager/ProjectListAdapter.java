package ru.valentin3131.taskmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectViewHolder> {
    private List<Project> projects = new ArrayList<Project>();

    public ProjectListAdapter(List<Project> projects) {this.projects = projects;};

    @Override
    public int getItemCount(){
        return projects.size();
    }

    @NonNull
    @Override
    public ProjectListAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each task item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);
        return new ProjectListAdapter.ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position){
        Project project = projects.get(position);
        holder.nameView.setText(project.getName());
    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;

        public ProjectViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.projectName_item);
        }
    }
}
