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

public class loginActivity extends AppCompatActivity {
    private Button btnToSignUp, btnToLogin;
    private ImageButton btnBackToWelcome;

    private TextInputEditText editTextemail,editTextpass;

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
        setContentView(R.layout.activity_login);


        progressBar = findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();
        editTextemail = findViewById(R.id.username);
        editTextpass = findViewById(R.id.password);
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
                progressBar.setVisibility(View.VISIBLE);
                String email,password;
                email = String.valueOf(editTextemail.getText());
                password = String.valueOf(editTextpass.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(loginActivity.this, "Nhập Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(loginActivity.this, "Nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),"Đăng Nhâp thành công",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(loginActivity.this, "Email hoặc mật khẩu không đúng",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                ;
            }
        });
    }
}