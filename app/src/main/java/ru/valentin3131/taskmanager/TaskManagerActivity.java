package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TaskManagerActivity extends AppCompatActivity {

    private EditText taskNameEditText;
    private EditText projectNameEditText;
    private Button searchTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_manager);

        taskNameEditText = findViewById(R.id.task_name_edit_text);
        projectNameEditText = findViewById(R.id.project_name_edit_text);
        searchTaskButton = findViewById(R.id.search_task_button);

        searchTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = taskNameEditText.getText().toString();
                String projectName = projectNameEditText.getText().toString();

                TaskManager taskManager = new TaskManager();
                List<Task> tasks = taskManager.searchTasksByKeyword(taskName);
                Toast.makeText(TaskManagerActivity.this, "Задачи найдены", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

