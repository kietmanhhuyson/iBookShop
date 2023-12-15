package com.ibookshop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ibookshop.R;

public class signUpActivity extends AppCompatActivity {
    private Button btnToLogin;
    private Button btnToSignup;
    private TextInputEditText editTextemail,editTextpass;
    private ImageButton btnBackToWelcome;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        progressBar = findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();
        btnToSignup = findViewById(R.id.btn_Dk);
        editTextemail = findViewById(R.id.email);
        editTextpass = findViewById(R.id.passwordsu);
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
                Intent intent = new Intent(signUpActivity.this, loginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email,password;
                email = String.valueOf(editTextemail.getText());
                password = String.valueOf(editTextpass.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(signUpActivity.this, "Nhập Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(signUpActivity.this, "Nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(signUpActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();


                                } else {


                                    Toast.makeText(signUpActivity.this, task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });
    }
}