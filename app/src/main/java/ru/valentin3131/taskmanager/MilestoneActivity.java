package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MilestoneActivity extends AppCompatActivity {

    private EditText milestoneNameEditText;
    private EditText milestoneDescriptionEditText;
    private Button createMilestoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone);

        milestoneNameEditText = findViewById(R.id.milestone_name_edit_text);
        milestoneDescriptionEditText = findViewById(R.id.milestone_description_edit_text);
        createMilestoneButton = findViewById(R.id.create_milestone_button);
        createMilestoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String milestoneName = milestoneNameEditText.getText().toString();
                String milestoneDescription = milestoneDescriptionEditText.getText().toString();

                Milestone milestone = new Milestone(milestoneName, milestoneDescription);
                Toast.makeText(MilestoneActivity.this, "The milestone was created", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

