package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.UUID;

public class EditTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_task);

        Bundle arguments = getIntent().getExtras();
        assert arguments != null;
        UUID uuid = UUID.fromString(arguments.getString("task_uuid"));
        Log.d("UUID", "Get uuid: " + uuid.toString());
        Task task = GlobalData.getInstance().getTask(uuid);
        if (task == null)
            Log.wtf("WTF", "task is null");
        else
            Log.i("TASK", task.getName());

        EditText nameField = findViewById(R.id.editTextTaskName);
        EditText statusField = findViewById(R.id.editTextTaskStatus);
        EditText priorityField = findViewById(R.id.editTextTaskPriority);
        EditText deadlineField = findViewById(R.id.editTextTaskDeadline);

        Log.d("CREATE", "Create all fields");

        nameField.setText(task.getName());
        Log.d("UPDATE", "Update name");
        statusField.setText(task.getStatus());
        Log.d("UPDATE", "Update status");
        priorityField.setText(String.format("%d", task.getPriority()));
        Log.d("UPDATE", "Update priority");
        deadlineField.setText(task.getDeadline().toString());
        Log.d("UPDATE", "Update deadline");
    }
}