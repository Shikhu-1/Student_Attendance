package com.studentattendance;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MarkAttendanceActivity extends AppCompatActivity {

    EditText etStudentName, etStudentID, etCourse, etDate;
    RadioGroup rgStatus;
    Button btnSave;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);

        db            = new DatabaseHelper(this);
        etStudentName = findViewById(R.id.etStudentName);
        etStudentID   = findViewById(R.id.etStudentID);
        etCourse      = findViewById(R.id.etCourse);
        etDate        = findViewById(R.id.etDate);
        rgStatus      = findViewById(R.id.rgStatus);
        btnSave       = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name   = etStudentName.getText().toString().trim();
            String id     = etStudentID.getText().toString().trim();
            String course = etCourse.getText().toString().trim();
            String date   = etDate.getText().toString().trim();
            String status = (rgStatus.getCheckedRadioButtonId() == R.id.rbPresent)
                    ? "Present" : "Absent";

            if (name.isEmpty() || id.isEmpty() || course.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean saved = db.insertAttendance(name, id, course, date, status);
            if (saved) {
                Toast.makeText(this, "Attendance saved!", Toast.LENGTH_SHORT).show();
                etStudentName.setText("");
                etStudentID.setText("");
                etCourse.setText("");
                etDate.setText("");
            } else {
                Toast.makeText(this, "Error saving attendance", Toast.LENGTH_SHORT).show();
            }
        });
    }
}