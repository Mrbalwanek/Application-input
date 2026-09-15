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

public class RegisterUserActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_user);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String login = etLogin.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (login.isEmpty()) {
                etLogin.setError("brakuje loginu 💀");
                etLogin.requestFocus();
            } else if (password.isEmpty()) {
                etPassword.setError("hasło gdzie? 👀");
                etPassword.requestFocus();
            } else if (password.length() < 4) {
                etPassword.setError("za krótkie, dorzuć znaków 📈");
                etPassword.requestFocus();
            } else {
                Toast.makeText(RegisterUserActivity.this, "zarejestrowano, no cap: " + login, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
