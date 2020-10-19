package com.esprit.recapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdateProfileActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        phoneEditText = findViewById(R.id.editTextPhone);
        firstNameEditText = findViewById(R.id.editTextFirstName);
        lastNameEditText = findViewById(R.id.editTextLastName);
        updateButton = findViewById(R.id.buttonUpdate);
        updateButton.setOnClickListener(l -> update());
        firstNameEditText.setText(getIntent().getStringExtra("firstName"));
        lastNameEditText.setText(getIntent().getStringExtra("lastName"));
        emailEditText.setText(getIntent().getStringExtra("email"));
        phoneEditText.setText(getIntent().getStringExtra("phone"));
    }

    private void update() {
        Intent intent = new Intent(UpdateProfileActivity.this, HomeActivity.class);
        intent.putExtra("firstName", firstNameEditText.getText().toString());
        intent.putExtra("lastName", lastNameEditText.getText().toString());
        intent.putExtra("email", emailEditText.getText().toString());
        intent.putExtra("phone", phoneEditText.getText().toString());
        startActivity(intent);
    }
}