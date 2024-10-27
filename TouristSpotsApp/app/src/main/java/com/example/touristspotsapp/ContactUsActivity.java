package com.example.touristspotsapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.touristspotsapp.R;
import com.google.android.material.textfield.TextInputLayout;

public class ContactUsActivity extends AppCompatActivity {
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutMessage;
    private EditText etName, etEmail, etMessage;
    private Button btnSubmitContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        inputLayoutName = findViewById(R.id.inputLayoutName);
        inputLayoutEmail = findViewById(R.id.inputLayoutEmail);
        inputLayoutMessage = findViewById(R.id.inputLayoutMessage);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etMessage = findViewById(R.id.etMessage);
        btnSubmitContact = findViewById(R.id.btnSubmitContact);

        btnSubmitContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String message = etMessage.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    inputLayoutName.setError("Please enter your name");
                } else if (TextUtils.isEmpty(email)) {
                    inputLayoutName.setError(null);
                    inputLayoutEmail.setError("Please enter your email");
                } else if (TextUtils.isEmpty(message)) {
                    inputLayoutEmail.setError(null);
                    inputLayoutMessage.setError("Please enter your message");
                } else {
                    inputLayoutName.setError(null);
                    inputLayoutEmail.setError(null);
                    inputLayoutMessage.setError(null);

                    Toast.makeText(ContactUsActivity.this, "Thank you, " + name + "! Your message has been sent.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ContactUsActivity.this, MainActivity.class);
                    startActivity(intent);

                    // Reset the fields after submission
                    etName.setText("");
                    etEmail.setText("");
                    etMessage.setText("");
                }
            }
        });
    }
}
