package com.esprit.recapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView fullNameTextView;
    private TextView emailTextView;
    private TextView phoneTextView;
    private Button fragment1Button;
    private Button updateButton;
    private Button fragment2Button;
    private Bundle extras = getIntent().getExtras();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fullNameTextView = findViewById(R.id.textViewFullName);
        emailTextView = findViewById(R.id.textViewEmail);
        phoneTextView = findViewById(R.id.textViewPhone);
        fragment1Button = findViewById(R.id.buttonFragment1);
        fragment2Button = findViewById(R.id.buttonFragment2);
        updateButton = findViewById(R.id.buttonUpdate);
        fullNameTextView.setText(extras.getString("firstName")+" "+extras.getString("LastName"));
        emailTextView.setText(extras.getString("email"));
        phoneTextView.setText(extras.getString("phone"));
    }
}