package com.example.jecrcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginStudent extends AppCompatActivity {
    private Button login;
    private EditText mEmail;
    private EditText mPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);
        mAuth = FirebaseAuth.getInstance();
        mEmail =(EditText) findViewById(R.id.emailText);
        mPassword =(EditText) findViewById(R.id.passwordText);
        login =(Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();
            }
        });
    }
    private void startLogin(){
        if(!validate()){
            return;
        }

        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        Intent intent = new Intent(LoginStudent.this,StudentMain.class);
                        startActivity(intent);
                       // Toast.makeText(LoginStudent.this,"Login Successful",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(LoginStudent.this,"Login Failed",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
    public boolean validate(){
        boolean allPassed = true;

        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        if(email.length() == 0){
            allPassed = false;
            mEmail.setError("Enter Email id");
        }
        if(password.length() == 0 ){
            allPassed = false;
            mPassword.setError("Enter Password");
        }
        return  allPassed;

    }
}
