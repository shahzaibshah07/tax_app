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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class efilling extends AppCompatActivity {
    private EditText inputFullname, inputCnic, inputDob, inputOccupation;
    TextView btnContinue;
    CheckBox ck1,ck2,ck3,ck4;
    private FirebaseDatabase mFirebaseDatabase;
    String userID;
    String national;
    String res;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;
    private DatabaseReference myRef;
    SharedPreferences sharedpreferences;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        setContentView(R.layout.activity_efilling);
        sharedpreferences = getSharedPreferences("home", Context.MODE_PRIVATE);
        progressDialog = new ProgressDialog(efilling.this);
        progressDialog.setMessage("Please Wait");
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        inputFullname = (EditText) findViewById(R.id.input_fullname);
        inputCnic = (EditText) findViewById(R.id.input_cnic);
        inputDob = (EditText) findViewById(R.id.input_dob);
        inputOccupation = (EditText) findViewById(R.id.input_occupation);
        btnContinue= (Button) findViewById(R.id.btn_continue);
       ck1= findViewById(R.id.checkbox1);
       ck2 =findViewById(R.id.checkbox2);
        ck3= findViewById(R.id.checkbox3);
        ck4 =findViewById(R.id.checkbox4);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fullname = inputFullname.getText().toString();
                final String cnic = inputCnic.getText().toString();
                final String dob = inputDob.getText().toString();
                final String occupation = inputOccupation.getText().toString();

                if (ck1.isChecked()) {
                   national="Pakistani";
                    Toast.makeText(getApplicationContext(), "pakistani selected", Toast.LENGTH_SHORT).show();

                }
                if (ck2.isChecked()) {
                    national="Forgein";
                    Toast.makeText(getApplicationContext(), "Forgein selected", Toast.LENGTH_SHORT).show();

                }
                if (ck3.isChecked()) {
                    res="Resident";
                    Toast.makeText(getApplicationContext(), " Resident selected", Toast.LENGTH_SHORT).show();

                }
                if (ck4.isChecked()) {
                    res="Non-Resident";
                    Toast.makeText(getApplicationContext(), "Non Resident selected", Toast.LENGTH_SHORT).show();

                }

                if (TextUtils.isEmpty(fullname)) {
                    Toast.makeText(getApplicationContext(), "Enter Fullname!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cnic)) {
                    Toast.makeText(getApplicationContext(), "Enter Your CNIC No!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(dob)) {
                    Toast.makeText(getApplicationContext(), "Enter Date Of Birth!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(occupation)) {
                    Toast.makeText(getApplicationContext(), "Enter your Occupation!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.show();
                //create user
                userID = auth.getCurrentUser().getUid();
                creatuser(inputFullname.getText().toString(),inputCnic.getText().toString(),inputDob.getText().toString(),inputOccupation.getText().toString(),national,res);




            }
        });
    }
    public void creatuser( String fullname, String cnic, String dob, String occupation,String national,String res) {

        Ntn settings = new Ntn(
                fullname,
                cnic,
                dob,
                occupation,national,res);
        final DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
//

        ref.child("E_Filling")
                .child(userID)
                .setValue(settings);
        progressDialog.dismiss();
        Intent i = new Intent(efilling.this,home.class);
        startActivity(i);
    }
}

