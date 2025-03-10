package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class EditTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_task);

        Bundle arguments = getIntent().getExtras();
        final Task task;
        // Fallback options for "No User" and "No Project"
        User noUser = new User("Not Assigned");
        Project noProject = new Project("No Project");

        UUID uuid = UUID.fromString(arguments.getString("task_uuid"));
        Log.d("UUID", "Received uuid: " + uuid.toString());
        task = GlobalData.getInstance().getTask(uuid);
        if (task == null) {
            Log.e("TASK", "Task is null");
            finish();
            return;
        }
        // Get copies of projects and users list, and add default options at position 0
        List<Project> projectList = GlobalData.getInstance().getProjectsCopy();
        List<User> userList = GlobalData.getInstance().getUsersCopy();
        projectList.add(0, noProject);
        userList.add(0, noUser);

        EditText nameField = findViewById(R.id.editTextTaskName);
        EditText statusField = findViewById(R.id.editTextTaskStatus);
        EditText priorityField = findViewById(R.id.editTextTaskPriority);
        EditText deadlineField = findViewById(R.id.editTextTaskDeadline);
        final Spinner projectSpinner = findViewById(R.id.spinnerProjects);
        final Spinner userSpinner = findViewById(R.id.spinnerUsers);
        Button saveButton = findViewById(R.id.buttonSaveTask);

        // Create adapters for spinners
        ArrayAdapter<Project> adapterPrj = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, projectList);
        adapterPrj.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        projectSpinner.setAdapter(adapterPrj);

        ArrayAdapter<User> adapterUsr = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, userList);
        adapterUsr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(adapterUsr);

        Log.d("CREATE", "All fields initialized");

        // Set task data
        nameField.setText(task.getName());
        statusField.setText(task.getStatus());
        priorityField.setText(String.format("%d", task.getPriority()));
        deadlineField.setText(GlobalData.dataFormat.format(task.getDeadline()));

        // Set selected project by default if exists
        if (task.getProjectUUID() != null) {
            for (int i = 0; i < projectList.size(); i++) {
                Project prj = projectList.get(i);
                if (prj.getUUID().equals(task.getProjectUUID())) {
                    projectSpinner.setSelection(i);
                    break;
                }
            }
        } else {
            projectSpinner.setSelection(0); // Default: No Project
        }

        // Set selected user by default if exists
        if (task.getAssignedUser() != null) {
            for (int i = 0; i < userList.size(); i++) {
                User usr = userList.get(i);
                if (usr.getUUID().equals(task.getAssignedUser().getUUID())) {
                    userSpinner.setSelection(i);
                    break;
                }
            }
        } else {
            userSpinner.setSelection(0); // Default: Not Assigned
        }

        // Save button click listener
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Read and validate fields
                String newName = nameField.getText().toString().trim();
                String newStatus = statusField.getText().toString().trim();
                String priorityValue = priorityField.getText().toString().trim();
                String deadlineValue = deadlineField.getText().toString().trim();

                if (newName.isEmpty() || newStatus.isEmpty() || priorityValue.isEmpty() || deadlineValue.isEmpty()) {
                    Toast.makeText(EditTask.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }

                int newPriority;
                try {
                    newPriority = Integer.parseInt(priorityValue);
                } catch (NumberFormatException e) {
                    Toast.makeText(EditTask.this, "Priority must be a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                Date newDeadline;
                try {
                    newDeadline = GlobalData.dataFormat.parse(deadlineValue);
                } catch (ParseException e) {
                    Toast.makeText(EditTask.this, "Deadline must be in format yyyy-MM-dd", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get selected project and user from spinners
                Project selectedProject = (Project) projectSpinner.getSelectedItem();
                User selectedUser = (User) userSpinner.getSelectedItem();

                // Update task data
                task.setName(newName);
                task.setStatus(newStatus);
                task.setPriority(newPriority);
                task.setDeadline(newDeadline);

                // Update project reference
                if (selectedProject.getName().equals("No Project")) {
                    task.setProject(null);
                } else {
                    task.setProject(selectedProject);
                }

                // Update assigned user reference
                if (selectedUser.getName().equals("Not Assigned")) {
                    task.setAssignedUser(null);
                } else {
                    task.setAssignedUser(selectedUser);
                }

                Toast.makeText(EditTask.this, "Task saved successfully", Toast.LENGTH_SHORT).show();

                // Finish activity if necessary
                finish();
            }
        });
    }
}
