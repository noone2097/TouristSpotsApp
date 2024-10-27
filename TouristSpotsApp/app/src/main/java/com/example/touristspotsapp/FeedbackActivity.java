package com.example.touristspotsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.touristspotsapp.R;

public class FeedbackActivity extends AppCompatActivity {
    private RadioGroup rgFeedback;
    private Button btnSubmitFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        rgFeedback = findViewById(R.id.rgFeedback);
        btnSubmitFeedback = findViewById(R.id.btnSubmitFeedback);

        btnSubmitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgFeedback.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String feedback = selectedRadioButton.getText().toString();
                    Toast.makeText(FeedbackActivity.this, "Feedback Submitted: " + feedback, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FeedbackActivity.this, MainActivity.class);
                    startActivity(intent);

                    // Reset the RadioGroup for new feedback
                    rgFeedback.clearCheck();
                } else {
                    Toast.makeText(FeedbackActivity.this, "Please select a feedback option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
