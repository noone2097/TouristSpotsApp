package com.example.touristspotsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class TouristSpotsListActivity extends AppCompatActivity {

    private ListView listView;
    private String[] touristSpots = {
            "Eiffel Tower",
            "Grand Canyon",
            "Great Wall of China",
            "Machu Picchu",
            "Santorini",
            "Tokyo Tower",
            "Sydney Opera House",
            "Colosseum"
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(TouristSpotsListActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_spots_list);

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, touristSpots
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSpot = touristSpots[position];
            Intent intent = new Intent(TouristSpotsListActivity.this, SpotDetailsActivity.class);
            intent.putExtra("spot_name", selectedSpot);
            startActivity(intent);
        });
    }
}
