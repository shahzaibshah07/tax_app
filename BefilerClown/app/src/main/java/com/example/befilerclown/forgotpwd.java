package com.example.befilerclown;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpwd extends AppCompatActivity {
    private EditText edtEmail;
    private Button btnResetPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.forgotpwd);
        mProgressBar = new ProgressDialog(this);

        edtEmail = (EditText) findViewById(R.id.email);
        btnResetPassword = (Button) findViewById(R.id.btn_rest);
        mAuth = FirebaseAuth.getInstance();

        mProgressBar.dismiss();

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                String email = edtEmail.getText().toString().trim();
//
//                if (TextUtils.isEmpty(email)) {
//                    Toast.makeText(getApplicationContext(), "Enter your email!", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                mAuth.sendPasswordResetEmail(edtEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(forgotpwd.this, "Check email to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(forgotpwd.this,  task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                } finish();
                            }
                        });
            }
        });

    }
}
