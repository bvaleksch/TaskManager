package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class EditTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_task);

        Bundle arguments = getIntent().getExtras();
        UUID uuid = UUID.fromString(arguments.getString("task_uuid"));
        Log.d("UUID", "Get uuid: " + uuid.toString());
        Task task = GlobalData.getInstance().getTask(uuid);
        if (task == null)
            Log.e("TASK", "task is null");

        EditText nameField = findViewById(R.id.editTextTaskName);
        EditText statusField = findViewById(R.id.editTextTaskStatus);
        EditText priorityField = findViewById(R.id.editTextTaskPriority);
        EditText deadlineField = findViewById(R.id.editTextTaskDeadline);

        Log.d("CREATE", "Create all fields");

        nameField.setText(task.getName());
        statusField.setText(task.getStatus());
        priorityField.setText(String.format("%d", task.getPriority()));
        deadlineField.setText(GlobalData.dataFormat.format(task.getDeadline()));
    }
}