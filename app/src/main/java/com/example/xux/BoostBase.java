package com.example.xux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BoostBase extends AppCompatActivity {


    private boolean isActiveRocket = true;
    private boolean isActiveBattery = false;
    private boolean isActiveFan = false;
    private boolean isActiveTrash = false;


    private ImageView r_nav;
    private ImageView b_nav;
    private ImageView t_nav;
    private ImageView f_nav;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boost_base);

        r_nav = findViewById(R.id.r_nav);
        b_nav = findViewById(R.id.b_nav);
        f_nav = findViewById(R.id.f_nav);
        t_nav = findViewById(R.id.t_nav);

        updateViews();
        BlankFragment_R blank = new BlankFragment_R();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, blank).commit();

        r_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isActiveRocket) {
                    int activeColor = ContextCompat.getColor(BoostBase.this, R.color.active_color);
                    int inactiveColor = ContextCompat.getColor(BoostBase.this, R.color.inactive_color);
                    r_nav.setImageTintList(ColorStateList.valueOf(inactiveColor));
                    r_nav.setBackgroundTintList(ColorStateList.valueOf(activeColor));

                    BlankFragment_R blank = new BlankFragment_R();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, blank).commit();

                    isActiveRocket = true;
                    isActiveBattery = false;
                    isActiveFan = false;
                    isActiveTrash = false;
                    updateViews();

                }
            }
        });

        b_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isActiveBattery) {
                    int activeColor = ContextCompat.getColor(BoostBase.this, R.color.active_color);
                    int inactiveColor = ContextCompat.getColor(BoostBase.this, R.color.inactive_color);
                    b_nav.setImageTintList(ColorStateList.valueOf(inactiveColor));
                    b_nav.setBackgroundTintList(ColorStateList.valueOf(activeColor));

                    BlankFragment_B blank = new BlankFragment_B();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, blank).commit();

                    isActiveRocket = false;
                    isActiveBattery = true;
                    isActiveFan = false;
                    isActiveTrash = false;

                    updateViews();
                }
            }
        });


        f_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isActiveFan) {
                    int activeColor = ContextCompat.getColor(BoostBase.this, R.color.active_color);
                    int inactiveColor = ContextCompat.getColor(BoostBase.this, R.color.inactive_color);
                    f_nav.setImageTintList(ColorStateList.valueOf(inactiveColor));
                    f_nav.setBackgroundTintList(ColorStateList.valueOf(activeColor));

                    BlankFragment_F blank = new BlankFragment_F();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, blank).commit();

                    isActiveRocket = false;
                    isActiveBattery = false;
                    isActiveFan = true;
                    isActiveTrash = false;
                    updateViews();

                }
            }
        });


        t_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isActiveTrash) {
                    int activeColor = ContextCompat.getColor(BoostBase.this, R.color.active_color);
                    int inactiveColor = ContextCompat.getColor(BoostBase.this, R.color.inactive_color);
                    t_nav.setImageTintList(ColorStateList.valueOf(inactiveColor));
                    t_nav.setBackgroundTintList(ColorStateList.valueOf(activeColor));

                    BlankFragment_T blank = new BlankFragment_T();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, blank).commit();

                    isActiveRocket = false;
                    isActiveBattery = false;
                    isActiveFan = false;
                    isActiveTrash = true;

                    updateViews();
                }
            }
        });

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }

    private void updateViews() {
        int activeColor = ContextCompat.getColor(BoostBase.this, R.color.active_color);
        int inactiveColor = ContextCompat.getColor(BoostBase.this, R.color.inactive_color);

        r_nav.setImageTintList(ColorStateList.valueOf(!isActiveRocket ? activeColor : inactiveColor));
        r_nav.setBackgroundTintList(ColorStateList.valueOf(!isActiveRocket ? inactiveColor : activeColor));

        b_nav.setImageTintList(ColorStateList.valueOf(!isActiveBattery ? activeColor : inactiveColor));
        b_nav.setBackgroundTintList(ColorStateList.valueOf(!isActiveBattery ? inactiveColor : activeColor));

        f_nav.setImageTintList(ColorStateList.valueOf(!isActiveFan ? activeColor : inactiveColor));
        f_nav.setBackgroundTintList(ColorStateList.valueOf(!isActiveFan ? inactiveColor : activeColor));

        t_nav.setImageTintList(ColorStateList.valueOf(!isActiveTrash ? activeColor : inactiveColor));
        t_nav.setBackgroundTintList(ColorStateList.valueOf(!isActiveTrash ? inactiveColor : activeColor));
    }
}