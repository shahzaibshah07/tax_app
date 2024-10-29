package com.example.befilerclown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class faqs extends AppCompatActivity {
    TextView qus1,qus2,qus3,qus4,qus5,ans1,ans2,ans3,ans4,ans5,qus6,ans6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        qus1=findViewById(R.id.qus1);
        ans1=findViewById(R.id.ans1);
        qus2=findViewById(R.id.qus2);
        ans2=findViewById(R.id.ans2);
        qus3=findViewById(R.id.qus3);
        ans3=findViewById(R.id.ans3);
        qus4=findViewById(R.id.qus4);
        ans4=findViewById(R.id.ans4);
        qus5=findViewById(R.id.qus5);
        ans5=findViewById(R.id.ans5);
        qus6=findViewById(R.id.qus6);
        ans6=findViewById(R.id.ans6);
        qus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans1.setVisibility(View.VISIBLE);
            }
        });
        qus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans2.setVisibility(View.VISIBLE);
            }
        });
        qus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans3.setVisibility(View.VISIBLE);
            }
        });
        qus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans4.setVisibility(View.VISIBLE);
            }
        });
        qus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans5.setVisibility(View.VISIBLE);
            }
        });
        qus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans6.setVisibility(View.VISIBLE);
            }

        });
    }
}