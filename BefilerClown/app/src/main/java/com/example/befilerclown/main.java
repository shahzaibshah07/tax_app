package com.example.befilerclown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class main extends AppCompatActivity {

    private static int SPLASH_TIME = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(main.this, login.class);
                startActivity(i);

            }
        },
                SPLASH_TIME);

    }


}