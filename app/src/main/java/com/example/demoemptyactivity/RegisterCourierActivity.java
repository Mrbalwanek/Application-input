package com.example.demoemptyactivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterCourierActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_courier);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String login = etLogin.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (login.isEmpty()) {
                etLogin.setError("Podaj login lub numer!");
                etLogin.requestFocus();
            } else if (password.isEmpty()) {
                etPassword.setError("Wpisz hasło!");
                etPassword.requestFocus();
            } else if (password.length() < 4) {
                etPassword.setError("Hasło musi mieć co najmniej 4 znaki!");
                etPassword.requestFocus();
            } else {
                String message = "Zarejestrowano pomyślnie: " + login;
                Toast.makeText(RegisterCourierActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
