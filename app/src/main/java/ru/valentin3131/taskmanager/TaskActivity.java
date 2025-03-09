package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskActivity extends AppCompatActivity {

    private EditText taskNameEditText;
    private EditText taskStatusEditText;
    private EditText taskPriorityEditText;
    private EditText taskDeadlineEditText;
    private Spinner userSpinner;
    private Button createTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        GlobalData globalData = GlobalData.getInstance();

        taskNameEditText = findViewById(R.id.task_name_edit_text);
        taskStatusEditText = findViewById(R.id.task_status_edit_text);
        taskPriorityEditText = findViewById(R.id.task_priority_edit_text);
        taskDeadlineEditText = findViewById(R.id.task_deadline_edit_text);
        userSpinner = findViewById(R.id.user_spinner);
        userSpinner.setVisibility(View.INVISIBLE);
        createTaskButton = findViewById(R.id.create_task_button);

        // Prepare a list for the Spinner. Add a "None" option at position 0.
        List<User> users = new ArrayList<>();
        // Add an empty user or null item for the "no selection" option.
        // Option 1: if User is an object, you can create a dummy User representing "No user".
        // Option 2: Use a String list.
        // In this example, we assume that GlobalData.getInstance().getUsers() returns List<User>.
        // We add a dummy object (or simply use null markers in adapter, but here we choose a dummy option).
        users.add(null); // null represents no selection.

        // Add all users from GlobalData
        List<User> globalUsers = globalData.getUsers();
        if (!globalUsers.isEmpty()) {
            users.addAll(globalUsers);
            userSpinner.setVisibility(View.VISIBLE);
        }

        // Create an ArrayAdapter.
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(adapter);

        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String taskName = taskNameEditText.getText().toString().trim();
                String taskStatus = taskStatusEditText.getText().toString().trim();
                String taskPriorityStr = taskPriorityEditText.getText().toString().trim();
                String taskDeadlineStr = taskDeadlineEditText.getText().toString().trim();

                if (taskName.isEmpty() || taskStatus.isEmpty() || taskPriorityStr.isEmpty() || taskDeadlineStr.isEmpty()) {
                    Toast.makeText(TaskActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                int taskPriority;
                try {
                    taskPriority = Integer.parseInt(taskPriorityStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(TaskActivity.this, "Invalid priority number", Toast.LENGTH_SHORT).show();
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date taskDeadline;
                try {
                    taskDeadline = sdf.parse(taskDeadlineStr);
                } catch (ParseException e) {
                    Toast.makeText(TaskActivity.this, "Invalid deadline format. Use yyyy-MM-dd.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get the selected user (if any)
                User selectedUser = (User) userSpinner.getSelectedItem();

                // Create a Task. Assume Task has been modified to accept an optional User argument.
                // For example, if the Task constructor is: Task(String name, String status, int priority, Date deadline)
                Task task = new Task(taskName, taskStatus, taskPriority, taskDeadline);
                globalData.addTask(task);
                if (selectedUser != null)
                    task.setAssignedUser(selectedUser);

                Toast.makeText(TaskActivity.this, "The task was created", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
