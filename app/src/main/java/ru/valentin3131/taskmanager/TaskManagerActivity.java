package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
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
        RecyclerView recyclerView = findViewById(R.id.recyclerViewFoundTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Task> tasks = new ArrayList<Task>();
        TaskAdapter adapter = new TaskAdapter(tasks);
        recyclerView.setAdapter(adapter);

        searchTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasks.clear();
                List<Task> tasks_original = new ArrayList<Task>();
                String taskName = taskNameEditText.getText().toString().toLowerCase();
                String projectName = projectNameEditText.getText().toString().toLowerCase();

                boolean found = false;
                if (projectName.isEmpty()){
                    tasks_original = GlobalData.getInstance().getTasks();
                } else {
                    for (Project project : GlobalData.getInstance().getProjects()) {
                        if (project.getName().equals(projectName)) {
                            tasks_original = project.getTasks();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        Toast.makeText(TaskManagerActivity.this, "Not found project", Toast.LENGTH_SHORT).show();
                    }
                }

                for (Task task : tasks_original) {
                    if (task.getName().toLowerCase().contains(taskName))
                        tasks.add(task.clone());
                }

                if (tasks.isEmpty()) {
                    if (found || projectName.isEmpty())
                        Toast.makeText(TaskManagerActivity.this, "Not found task", Toast.LENGTH_SHORT).show();
                }

                adapter.notifyDataSetChanged();
            }
        });
    }
}

