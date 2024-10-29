package com.example.befilerclown;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

public class home extends AppCompatActivity {
    ImageButton efilling_button, register_ntn, verify_ntn, btn_calculator, btn_faqs;
    ImageView tool, tool1, tool2, tool3, call,message, email, whatsapp;
    FirebaseAuth auth;
    ImageButton communicate;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;


    //Toolbar toolbar = findViewById(R.id.too)
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dl = (DrawerLayout) findViewById(R.id.activity_main);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user == null) {
            gotologin();
        }
        tool=findViewById(R.id.tool);
        tool3 = (ImageView) findViewById(R.id.tool3);
        call = findViewById(R.id.call);
        message=findViewById(R.id.message);
        email = findViewById(R.id.email);
        whatsapp = findViewById(R.id.whatsapp);
        efilling_button = findViewById(R.id.btn_efilling);
        register_ntn = findViewById(R.id.btn_register);
        verify_ntn = findViewById(R.id.btn_verify);
        btn_calculator = findViewById(R.id.btn_calculator);
        btn_faqs = findViewById(R.id.btn_faqs);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_item_one:
                        // Toast.makeText(MainActivity.this, "My Account",Toast.LENGTH_SHORT).show();
                        Intent mySuperIntent = new Intent(home.this, home.class);
                        startActivity(mySuperIntent);
                        break;
                    case R.id.nav_item_two:
                        Intent i = new Intent(home.this, settings.class);
                        startActivity(i);
                        // Toast.makeText(MainActivity.this, "Settings",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_item_three:
                        // Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_item_four:
                        // Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(home.this, login.class);
                        startActivity(intent);
                        auth.signOut();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });



        efilling_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this, efilling.class);
                startActivity(i);
            }

        });
        register_ntn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this, register_ntn.class);
                startActivity(i);
            }
        });
        verify_ntn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this, verify_ntn.class);
                startActivity(i);
            }
        });
        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://taxcalculator.pk/=";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn_faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this, faqs.class);
                startActivity(i);
            }

        });
       tool.setOnClickListener(new View.OnClickListener() {
        @SuppressLint("WrongConstant")
        @Override
         public void onClick(View v) {
         if(!dl.isDrawerOpen(Gravity.START)) dl.openDrawer(Gravity.START);
         else dl.closeDrawer(Gravity.END);
         }
         });




        tool3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(home.this, tool3);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.menu, popup.getMenu());
                          popup.show();
                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (item.getItemId()) {
                            case R.id.call:
                                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                                callIntent.setData(Uri.parse("tel:03365596173"));
                                startActivity(callIntent);

                                return true;
                            case R.id.message:
                                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
                                        Uri.parse("sms:03365596173"));
                                startActivity(smsIntent);

                                return true;

                            case R.id.email:
                                Intent intent=new Intent(Intent.ACTION_SEND);
                                String[] recipients={"mailto@gmail.com"};
                                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                                intent.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
                                intent.setType("text/html");
                                intent.setPackage("com.google.android.gm");
                                startActivity(Intent.createChooser(intent, "Send mail"));
                                return true;

                            case R.id.whatsapp:
                                String url = "https://api.whatsapp.com/send?phone="+"03365596173";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                                return true;

                            default:
                                return false;
                        }
                    }
                });

                popup.show(); //showing popup menu
            }
        });
    }
    private void gotologin() {
        startActivity(new Intent(home.this, login.class));
        finish();
    }
}



