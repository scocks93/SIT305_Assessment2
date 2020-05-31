package com.example.assessment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Budget Wiz");

        final EditText usernameEditText = findViewById(R.id.usernameEditText);
        final EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button regButton = findViewById(R.id.regButton);

        db = new DatabaseHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = db.fetchUser(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                if (result == true) {
                    Toast.makeText(MainActivity.this, "Log in successful.", Toast.LENGTH_LONG).show();
                    Intent overviewIntent = new Intent(MainActivity.this, OverviewActivity.class);
                    startActivity(overviewIntent);
                }
                else {
                    Toast.makeText(MainActivity.this, "User not found.", Toast.LENGTH_LONG).show();
                }
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }

    public void startClick(View view) {
        Intent intent = new Intent(this, OverviewActivity.class);
        startActivity(intent);
    }
}
