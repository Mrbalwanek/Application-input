package com.example.demoemptyactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterCourierActivity extends AppCompatActivity {

    private TextInputLayout tilLogin;
    private TextInputLayout tilPassword;
    private TextInputEditText etLogin;
    private TextInputEditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_courier);

        View root = findViewById(R.id.main);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            toolbar.setPadding(toolbar.getPaddingLeft(), systemBars.top, toolbar.getPaddingRight(), toolbar.getPaddingBottom());
            v.setPadding(0, 0, 0, systemBars.bottom);
            return insets;
        });

        toolbar.setNavigationOnClickListener(v -> finish());

        tilLogin = findViewById(R.id.tilLogin);
        tilPassword = findViewById(R.id.tilPassword);
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        MaterialButton btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String login = etLogin.getText() == null ? "" : etLogin.getText().toString().trim();
            String password = etPassword.getText() == null ? "" : etPassword.getText().toString().trim();

            tilLogin.setError(null);
            tilPassword.setError(null);

            if (login.isEmpty()) {
                tilLogin.setError("Podaj login lub numer!");
            } else if (password.isEmpty()) {
                tilPassword.setError("Wpisz hasło!");
            } else if (password.length() < 4) {
                tilPassword.setError("Hasło musi mieć co najmniej 4 znaki!");
            } else {
                String message = "Zarejestrowano pomyślnie: " + login;
                Toast.makeText(RegisterCourierActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
