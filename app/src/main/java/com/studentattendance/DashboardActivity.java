package com.studentattendance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    Button btnMarkAttendance, btnViewAttendance, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnMarkAttendance = findViewById(R.id.btnMarkAttendance);
        btnViewAttendance = findViewById(R.id.btnViewAttendance);
        btnLogout         = findViewById(R.id.btnLogout);

        btnMarkAttendance.setOnClickListener(v ->
                startActivity(new Intent(this, MarkAttendanceActivity.class)));

        btnViewAttendance.setOnClickListener(v ->
                startActivity(new Intent(this, ViewAttendanceActivity.class)));

        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}