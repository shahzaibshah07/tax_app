package com.example.befilerclown;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class settings extends AppCompatActivity {
    EditText mFullname,mCnic,mdob,moccupation;
    EditText mcurrentPass,mnewPass,mcnfrm_newpass;
    TextView txt1,txt2;
    Button btn,btn1;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth auth;
    private DatabaseReference myRef;
    String name;
    String cnic;
    String dob;
    String occupation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        txt1=findViewById(R.id.txt1);
        mFullname=findViewById(R.id.fullname);
        mCnic=findViewById(R.id.cnic);
        mdob=findViewById(R.id.dob);
        moccupation=findViewById(R.id.occupation);
        btn=findViewById(R.id.btn);
        txt2=findViewById(R.id.txt2);
        mcurrentPass=findViewById(R.id.current_pass);
        mnewPass=findViewById(R.id.new_pass);
        mcnfrm_newpass=findViewById(R.id.cnfrm_new_pass);
        btn1=findViewById(R.id.btn1);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();





        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFullname.setVisibility(View.VISIBLE);
                mCnic.setVisibility(View.VISIBLE);
                mdob.setVisibility(View.VISIBLE);
                moccupation.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcurrentPass.setVisibility(View.VISIBLE);
                mnewPass.setVisibility(View.VISIBLE);
                mcnfrm_newpass.setVisibility(View.VISIBLE);
                btn1.setVisibility(View.VISIBLE);
            }
        });


     }

}