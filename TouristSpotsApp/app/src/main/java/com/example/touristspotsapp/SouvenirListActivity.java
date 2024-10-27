package com.example.touristspotsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SouvenirListActivity extends AppCompatActivity {

    private CheckBox cbKeychain, cbTShirt, cbMug, cbPostcard, cbHat;
    private TextView tvTotalPrice;
    private Button btnPlaceOrder;
    private int totalPrice = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_souvenir_list);

        // Initialize CheckBoxes
        cbKeychain = findViewById(R.id.cbKeychain);
        cbTShirt = findViewById(R.id.cbTShirt);
        cbMug = findViewById(R.id.cbMug);
        cbPostcard = findViewById(R.id.cbPostcard);
        cbHat = findViewById(R.id.cbHat);

        // Initialize TextView and Button
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);

        // Set onClickListener for the Place Order button
        btnPlaceOrder.setOnClickListener(view -> placeOrder());

        // Set listeners for each CheckBox to automatically update the total price
        cbKeychain.setOnCheckedChangeListener((buttonView, isChecked) -> updatePrice());
        cbTShirt.setOnCheckedChangeListener((buttonView, isChecked) -> updatePrice());
        cbMug.setOnCheckedChangeListener((buttonView, isChecked) -> updatePrice());
        cbPostcard.setOnCheckedChangeListener((buttonView, isChecked) -> updatePrice());
        cbHat.setOnCheckedChangeListener((buttonView, isChecked) -> updatePrice());
    }

    private void updatePrice() {
        totalPrice = 0;

        // Prices for each souvenir item
        int priceKeychain = 50;
        int priceTShirt = 200;
        int priceMug = 100;
        int pricePostcard = 20;
        int priceHat = 150;

        // Check each CheckBox and add the respective price if checked
        if (cbKeychain.isChecked()) {
            totalPrice += priceKeychain;
        }
        if (cbTShirt.isChecked()) {
            totalPrice += priceTShirt;
        }
        if (cbMug.isChecked()) {
            totalPrice += priceMug;
        }
        if (cbPostcard.isChecked()) {
            totalPrice += pricePostcard;
        }
        if (cbHat.isChecked()) {
            totalPrice += priceHat;
        }

        // Display the total price
        tvTotalPrice.setText("Total Price: ₱" + totalPrice);
    }

    private void placeOrder() {
        if (totalPrice > 0) {
            Toast.makeText(this, "Order placed", Toast.LENGTH_SHORT).show();
            resetCheckBoxes();
            Intent intent = new Intent(SouvenirListActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please select at least one souvenir.", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetCheckBoxes() {
        cbKeychain.setChecked(false);
        cbTShirt.setChecked(false);
        cbMug.setChecked(false);
        cbPostcard.setChecked(false);
        cbHat.setChecked(false);
        updatePrice(); // Reset the displayed total price to zero
    }
}
