package ru.valentin3131.taskmanager;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy");

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each task item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.nameTextView.setText(task.getName());
        holder.statusTextView.setText("Status: " + task.getStatus());
        holder.priorityTextView.setText("Priority: " + task.getPriority());
        holder.deadlineTextView.setText("Deadline: " + dateFormat.format(task.getDeadline()));
        // If needed, you can also display assigned user details
        if (task.getAssignedUser() != null) {
            holder.assignedUserTextView.setText("Assigned to: " + task.getAssignedUser().getName());
        } else {
            holder.assignedUserTextView.setText("Unassigned");
        }

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Item clicked", Toast.LENGTH_SHORT).show();
            Log.d("RUN", "Creating intent");
            Intent intent = new Intent(v.getContext(), EditTask.class);
            Log.d("UUID", "Send uuid: " + task.getUUID().toString());
            intent.putExtra("task_uuid", task.getUUID().toString());
            Log.d("RUN", "Start EditActivity");
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView statusTextView;
        TextView priorityTextView;
        TextView deadlineTextView;
        TextView assignedUserTextView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.taskName);
            statusTextView = itemView.findViewById(R.id.taskStatus);
            priorityTextView = itemView.findViewById(R.id.taskPriority);
            deadlineTextView = itemView.findViewById(R.id.taskDeadline);
            assignedUserTextView = itemView.findViewById(R.id.taskAssignedUser);
        }
    }
}
