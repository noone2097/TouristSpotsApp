package com.example.touristspotsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SpotDetailsActivity extends AppCompatActivity {

    private TextView spotNameTextView, spotDescriptionTextView;
    private ImageView spotImageView;
    private Button BackButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_details);

        spotNameTextView = findViewById(R.id.spotNameTextView);
        spotDescriptionTextView = findViewById(R.id.spotDescriptionTextView);
        spotImageView = findViewById(R.id.spotImageView);
        BackButton = findViewById(R.id.backButton);

        // Retrieve the spot name from the Intent
        String spotName = getIntent().getStringExtra("spot_name");
        spotNameTextView.setText(spotName);

        // Set the description and image based on the spot name
        setSpotDetails(spotName);

        BackButton.setOnClickListener(view -> {
            Intent intent = new Intent(SpotDetailsActivity.this, TouristSpotsListActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private void setSpotDetails(String spotName) {
        int imageResId = R.drawable.default_image; // Replace with a generic image for all spots
        String description = "";

        switch (spotName) {
            case "Eiffel Tower":
                imageResId = R.drawable.eiffel_tower; // Replace with actual image resources
                description = "The Eiffel Tower is an iron tower located in Paris, France.";
                break;
            case "Grand Canyon":
                imageResId = R.drawable.grand_canyon;
                description = "The Grand Canyon is a steep-sided canyon carved by the Colorado River in Arizona, USA.";
                break;
            case "Great Wall of China":
                imageResId = R.drawable.great_wall_of_china;
                description = "The Great Wall of China is a series of fortifications built along the northern borders of China.";
                break;
            // Add more cases for other spots
            case "Machu Picchu":
                imageResId = R.drawable.machu_picchu;
                description = "Machu Picchu is an Incan citadel set high in the Andes Mountains in Peru.";
                break;
            case "Santorini": // Add more cases for other spots
                imageResId = R.drawable.santorini;
                description = "Santorini is a Greek island in the southern Aegean Sea.";
                break;
            case "Tokyo Tower": // Add more cases for other spots
                imageResId = R.drawable.tokyo_tower;
                description = "Tokyo Tower is a communications and observation tower in Tokyo, Japan.";
                break;
            case "Sydney Opera House": // Add more cases for other spots
                imageResId = R.drawable.sydney_opera_house;
                description = "The Sydney Opera House is a multi-venue performing arts center in Sydney, Australia.";
                break;
            case "Colosseum": // Add more cases for other spots
                imageResId = R.drawable.colosseum;
                description = "The Colosseum is an oval amphitheater in the center of Rome, Italy.";
                break;
            default:
                description = "Description of " + spotName + " not available.";
                break;
        }

        spotImageView.setImageResource(imageResId);
        spotDescriptionTextView.setText(description);
    }
}
