package com.ibookshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.ibookshop.R;

public class loginActivity extends AppCompatActivity {
    private Button btnToSignUp, btnToLogin;
    private ImageButton btnBackToWelcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        btnToLogin = findViewById(R.id.BtnLogin);
        btnBackToWelcome = findViewById(R.id.iBtn_back);
        btnToSignUp = findViewById(R.id.BtnSignup);
        btnToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, signUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnBackToWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this,welcomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}