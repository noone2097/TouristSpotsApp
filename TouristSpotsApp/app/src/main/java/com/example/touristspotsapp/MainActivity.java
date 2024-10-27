package com.example.touristspotsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.OnBackPressedCallback;

public class MainActivity extends AppCompatActivity {
    private Button spotsButton, souvenirButton, feedbackButton, aboutButton, contactButton, logoutButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spotsButton = findViewById(R.id.spotsButton);
        souvenirButton = findViewById(R.id.souvenirButton);
        feedbackButton = findViewById(R.id.feedbackButton);
        aboutButton = findViewById(R.id.aboutButton);
        contactButton = findViewById(R.id.contactButton);
        logoutButton = findViewById(R.id.logoutButton);


        spotsButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, TouristSpotsListActivity.class)));
        souvenirButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SouvenirListActivity.class)));
        feedbackButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FeedbackActivity.class)));
        aboutButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AboutActivity.class)));
        contactButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ContactUsActivity.class)));
        logoutButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finishAffinity(); // Exit the app
            }
        });
    }
}
