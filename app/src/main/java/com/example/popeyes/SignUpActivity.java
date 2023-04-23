package com.example.popeyes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import androidx.annotation.NonNull;


import android.content.Intent;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignUpActivity extends AppCompatActivity {
    EditText mEmail,mPassword,mName;
    Button mSignup ,mBtnVerify;
    TextView mLogin,mTextverify;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mName=findViewById(R.id.edt_name);
        mEmail=findViewById(R.id.edt_email);
        mPassword=findViewById(R.id.edt_password);
        mSignup=findViewById(R.id.btn_signup);
        mLogin=findViewById(R.id.text_login);

        fAuth=FirebaseAuth.getInstance();




        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName=mName.getText().toString().trim();
                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(fullName)) {
                    mName.setError("name is required");
                    return;
                }

                if(TextUtils.isEmpty(email)) {
                    mEmail.setError("email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    mPassword.setError("password is required");
                }
                if(password.length()<6) {
                    mPassword.setError("password must have at least 6 character");
                }

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {

                            FirebaseUser user=fAuth.getCurrentUser();
                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(SignUpActivity.this,"verification email has been sent",Toast.LENGTH_SHORT).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(SignUpActivity.this, "error: email not sent "+e.getMessage() ,Toast.LENGTH_SHORT).show();

                                }
                            });




                            Toast.makeText(SignUpActivity.this,"user created",Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(SignUpActivity.this, "error"+task.getException().getMessage() ,Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                {

                }

            }
        });




        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}

