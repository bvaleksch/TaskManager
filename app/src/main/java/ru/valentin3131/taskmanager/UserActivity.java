package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private Button createUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        GlobalData globalData = GlobalData.getInstance();
        userNameEditText = findViewById(R.id.user_name_edit_text);
        createUserButton = findViewById(R.id.create_user_button);

        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEditText.getText().toString();

                User user = new User(userName);
                globalData.addUser(user);
                Toast.makeText(UserActivity.this, "The user was created", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
