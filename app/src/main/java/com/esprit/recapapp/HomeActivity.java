package com.esprit.recapapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
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
    private String firstName;
    private String lastName;

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
        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("LastName");
        fullNameTextView.setText(firstName + "" + lastName);
        emailTextView.setText(getIntent().getStringExtra("email"));
        phoneTextView.setText(getIntent().getStringExtra("phone"));
        fragment1Button.setOnClickListener(l -> showFragment(new FragmentOne()));
        fragment2Button.setOnClickListener(l -> showFragment(new FragmentTwo()));
        updateButton.setOnClickListener(l -> update());

    }

    private void update() {
        Intent intent = new Intent(HomeActivity.this, UpdateProfileActivity.class);

        intent.putExtra("firstName", firstName);
        intent.putExtra("lastName", lastName);
        intent.putExtra("email", emailTextView.getText().toString());
        intent.putExtra("phone", phoneTextView.getText().toString());
        startActivity(intent);
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}