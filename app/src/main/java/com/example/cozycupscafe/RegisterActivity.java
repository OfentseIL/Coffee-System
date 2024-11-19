package com.example.cozycupscafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    public ImageView logo;
    public TextView textView3, textView4, textView5;
    public EditText editText1, editText2, editText3;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // Initialize views
        logo = findViewById(R.id.logo);
        editText1 = findViewById(R.id.editText1); // Full Name
        editText2 = findViewById(R.id.editText2); // Email Address
        editText3 = findViewById(R.id.editText3); // Password

        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        button = findViewById(R.id.button);

        // Register Button OnClickListener
        button.setOnClickListener(v -> {
            // Step 1: Get input text from EditText fields
            String fullName = editText1.getText().toString().trim();
            String email = editText2.getText().toString().trim();
            String password = editText3.getText().toString().trim();

            // Step 2: Validate inputs (basic validation)
            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                // Show a message if fields are empty
                Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Step 3: Handle Registration logic (e.g., send data to the server)
            // For this example, let's assume registration is successful.

            // Step 4: After successful registration, navigate to LoginActivity
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);

            // Optionally, close the current RegisterActivity so the user can't go back to it
            finish();
        });

        // "Already registered?" link - Navigate to LoginActivity
        textView5.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        // Set up Edge-to-Edge padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
