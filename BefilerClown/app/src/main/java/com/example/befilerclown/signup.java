package com.example.befilerclown;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    private EditText inputEmail,inputMobile ,inputPassword, inputConfirmpass;
    TextView btnSignIn, btnSignUp, btnResetPassword;
    private FirebaseDatabase mFirebaseDatabase;
    String userID;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;
    private DatabaseReference myRef;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        setContentView(R.layout.signup);
        final SharedPreferences sharedpreferences = getSharedPreferences("home", Context.MODE_PRIVATE);
        progressDialog = new ProgressDialog(signup.this);
        progressDialog.setMessage("Please Wait");
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        btnSignIn = findViewById(R.id.link_login);
        btnSignUp = findViewById(R.id.btn_signup);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputMobile = (EditText) findViewById(R.id.input_mobil);
         inputPassword= (EditText) findViewById(R.id.input_password);
        inputConfirmpass = (EditText) findViewById(R.id.input_confimrpass);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(signup.this,login.class);
                  startActivity(i);
            }
        });
        
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();
                final String mobile = inputMobile.getText().toString();
                final String confirmpass = inputConfirmpass.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mobile)) {
                    Toast.makeText(getApplicationContext(), "Enter Your Contact No!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmpass)) {
                    Toast.makeText(getApplicationContext(), "Confirm your password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 8 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (confirmpass.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 8 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.show();
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(signup.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(signup.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putString("email", inputEmail.getText().toString());
                                    editor.putString("number", mobile);
                                    editor.putString("uid", auth.getCurrentUser().getUid());
                                    editor.apply();
                                    userID = auth.getCurrentUser().getUid();
                                    creatuser(auth.getCurrentUser().getUid(),inputEmail.getText().toString(),mobile,password);
                                    startActivity(new Intent(signup.this, login.class));
                                    finish();
                                }
                            }
                        });
            }

            private void creatuser(String uid, String email, String mobile, String password) {

                User settings = new User(
                        email,
                        uid,
                        password,
                        mobile
                );

                myRef.child("Users")
                        .child(userID)
                        .setValue(settings);
            }
        });
    }
    }

