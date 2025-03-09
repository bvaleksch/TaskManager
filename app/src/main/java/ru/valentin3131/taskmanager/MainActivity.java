package ru.valentin3131.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.valentin3131.taskmanager.MilestoneActivity;
import ru.valentin3131.taskmanager.ProjectActivity;
import ru.valentin3131.taskmanager.ReportActivity;
import ru.valentin3131.taskmanager.TaskActivity;
import ru.valentin3131.taskmanager.TaskManagerActivity;
import ru.valentin3131.taskmanager.UserActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button taskButton = findViewById(R.id.task_button);
        taskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                startActivity(intent);
            }
        });

        Button projectButton = findViewById(R.id.project_button);
        projectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProjectActivity.class);
                startActivity(intent);
            }
        });

        Button userButton = findViewById(R.id.user_button);
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        Button taskManagerButton = findViewById(R.id.task_manager_button);
        taskManagerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskManagerActivity.class);
                startActivity(intent);
            }
        });

        Button milestoneButton = findViewById(R.id.milestone_button);
        milestoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MilestoneActivity.class);
                startActivity(intent);
            }
        });

        Button reportButton = findViewById(R.id.report_button);
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReportActivity.class);
                startActivity(intent);
            }
        });

        Button taskListButton = findViewById(R.id.list_tasks);
        taskListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
                startActivity(intent);
            }
        });
    }
}
