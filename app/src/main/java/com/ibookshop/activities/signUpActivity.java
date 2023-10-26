package com.ibookshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.ibookshop.R;

public class signUpActivity extends AppCompatActivity {
    private Button btnToLogin;
    private ImageButton btnBackToWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        btnToLogin = findViewById(R.id.Btnback);
        btnBackToWelcome = findViewById(R.id.iBtn_back1);
        btnBackToWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUpActivity.this,welcomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUpActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}