package com.example.demoemptyactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RoleSelectionActivity extends AppCompatActivity {

    public static final String EXTRA_MODE = "mode";
    public static final String MODE_REGISTER = "register";
    public static final String MODE_LOGIN = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_role_selection);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        String mode = getIntent().getStringExtra(EXTRA_MODE);

        View cardUser = findViewById(R.id.cardUser);
        View cardCourier = findViewById(R.id.cardCourier);

        cardUser.setOnClickListener(v -> openTarget(mode, false));
        cardCourier.setOnClickListener(v -> openTarget(mode, true));
    }

    private void openTarget(String mode, boolean isCourier) {
        Class<?> target;
        if (MODE_REGISTER.equals(mode)) {
            target = isCourier ? RegisterCourierActivity.class : RegisterUserActivity.class;
        } else {
            target = isCourier ? LoginCourierActivity.class : LoginUserActivity.class;
        }
        startActivity(new Intent(this, target));
    }
}
