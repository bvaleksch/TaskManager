package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectActivity extends AppCompatActivity {

    private EditText projectNameEditText;
    private Button createProjectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        projectNameEditText = findViewById(R.id.project_name_edit_text);
        createProjectButton = findViewById(R.id.create_project_button);

        createProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String projectName = projectNameEditText.getText().toString();

                Project project = new Project(projectName);
                GlobalData.getInstance().addProject(project);
                Toast.makeText(ProjectActivity.this, "The project was created", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
