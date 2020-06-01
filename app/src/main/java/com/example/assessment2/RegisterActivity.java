package com.example.assessment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");

        final EditText userEditText = findViewById(R.id.userEditText);
        final EditText createPasswordEditText = findViewById(R.id.createPasswordEditText);
        final EditText createPasswordEditText2 = findViewById(R.id.createPasswordEditText2);
        Button registerButton = findViewById(R.id.registerButton);
        db = new DatabaseHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userEditText.getText().toString().trim();
                String password = createPasswordEditText.getText().toString().trim();
                String confirmedPassword = createPasswordEditText2.getText().toString().trim();

                if (password.equals(confirmedPassword)) {
                    long result = db.insert(user, password);

                    if (result > 0) {
                        Toast.makeText(RegisterActivity.this, "Registration Successful.", Toast.LENGTH_LONG).show();
                        Intent backIntent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(backIntent);
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "Registration Error.", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void cancelClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}