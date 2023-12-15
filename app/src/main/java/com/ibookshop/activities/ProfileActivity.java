package com.ibookshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ibookshop.R;
import com.ibookshop.utils.Utils;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseUser user;
    private TextView txtEmail;
    private ImageView imgHome, imgLogout, imgToXml;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtEmail = findViewById(R.id.txtEmail);
        imgHome = findViewById(R.id.prf_Home);
        imgLogout = findViewById(R.id.prf_logOut);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        txtEmail.setText(user.getEmail());

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent intent = new Intent(ProfileActivity.this,welcomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}