package com.example.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.lms.auth.userLogin;

public class MainActivity extends AppCompatActivity {

    Button StudentBtn,AdminBtn,FacultyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentBtn = findViewById(R.id.studentBtn);
        AdminBtn = findViewById(R.id.adminBtn);
        FacultyBtn = findViewById(R.id.facultyBtn);


        StudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice;
                choice="Student";
                Intent intent = new Intent(MainActivity.this,
                        userLogin.class);
                intent.putExtra("ChoiceButton",choice);
                startActivity(intent);
            }
        });

        AdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice;
                choice="Admin";
                Intent intent2 = new Intent(MainActivity.this,
                        userLogin.class);
                intent2.putExtra("ChoiceButton",choice);
                startActivity(intent2);

            }
        });

        FacultyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice;
                choice="Faculty";
                Intent intent3 = new Intent(MainActivity.this,
                        userLogin.class);
                intent3.putExtra("ChoiceButton",choice);
                startActivity(intent3);

            }
        });
    }
}