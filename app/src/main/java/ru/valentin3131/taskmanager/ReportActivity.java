package ru.valentin3131.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Button generateReportButton = findViewById(R.id.generate_report_button);
        generateReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText startDateEditText = findViewById(R.id.start_date_edit_text);
                EditText endDateEditText = findViewById(R.id.end_date_edit_text);
                TextView reportTextView = findViewById(R.id.report_text_view);

                String startDateStr = startDateEditText.getText().toString();
                String endDateStr = endDateEditText.getText().toString();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date startDate = dateFormat.parse(startDateStr);
                    Date endDate = dateFormat.parse(endDateStr);

                    String report = generateReport(startDate, endDate);
                    reportTextView.setText(report);
                } catch (ParseException e) {
                    Toast.makeText(ReportActivity.this, "Incorrect date", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String generateReport(Date startDate, Date endDate) {
        return "Report from " + startDate + " to " + endDate;
    }
}


