package com.esprit.recapapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
    private String fullName;
    private Bundle extras = this.getIntent().getExtras();

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
        fullName = extras.getString("firstName") + " " + extras.getString("LastName");
        fullNameTextView.setText(fullName);
        emailTextView.setText(extras.getString("email"));
        phoneTextView.setText(extras.getString("phone"));
        fragment1Button.setOnClickListener(l -> showFragment(new FragmentOne()));
        fragment2Button.setOnClickListener(l -> showFragment(new FragmentTwo()));

    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}