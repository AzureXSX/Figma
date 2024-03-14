package com.example.xux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
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


    private boolean isOptimizedRocket = false;
    private boolean isOptimizedBattery = false;
    private boolean isOptimizedFan = false;
    private boolean isOptimizedTrash = false;


    public boolean get_isOptimizedRocket(){
        return this.isOptimizedRocket;
    }

    public void set_isOptimizedRocket(boolean value){
        this.isOptimizedRocket = value;
        updateViews();
        ImageView img = this.findViewById(R.id.A1);
        img.setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_IN);
    }

    public boolean get_isOptimizedBattery(){
        return this.isOptimizedBattery;
    }

    public void set_isOptimizedBattery(boolean value){
        this.isOptimizedBattery = value;
        updateViews();
        ImageView img = this.findViewById(R.id.A2);
        img.setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_IN);
    }


    public boolean get_isOptimizedFan(){
        return this.isOptimizedFan;
    }

    public void set_isOptimizedFan(boolean value){
        this.isOptimizedFan = value;
        updateViews();
        ImageView img = this.findViewById(R.id.A3);
        img.setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_IN);
    }

    public boolean get_isOptimizedTrash(){
        return this.isOptimizedTrash;
    }

    public void set_isOptimizedTrash(boolean value){
        this.isOptimizedTrash = value;
        updateViews();
        ImageView img = this.findViewById(R.id.A4);
        img.setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_IN);
    }


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
        int darkblue = ContextCompat.getColor(BoostBase.this, R.color.active_color);
        int white = ContextCompat.getColor(BoostBase.this, R.color.inactive_color);
        int attentionColor = ContextCompat.getColor(BoostBase.this, R.color.attention_color);

        int color = isActiveRocket ? white : darkblue;


        r_nav.setImageTintList(ColorStateList.valueOf(isActiveRocket ? isOptimizedRocket ? white : attentionColor : isOptimizedRocket ? darkblue : attentionColor));
        r_nav.setBackgroundTintList(ColorStateList.valueOf(isActiveRocket ? darkblue : white));

        b_nav.setImageTintList(ColorStateList.valueOf(isActiveBattery ? isOptimizedBattery ? white : attentionColor : isOptimizedBattery ? darkblue : attentionColor));
        b_nav.setBackgroundTintList(ColorStateList.valueOf(isActiveBattery ? darkblue : white));

        f_nav.setImageTintList(ColorStateList.valueOf(isActiveFan ? isOptimizedFan ? white : attentionColor : isOptimizedFan ? darkblue : attentionColor));
        f_nav.setBackgroundTintList(ColorStateList.valueOf(isActiveFan ? darkblue : white));

        t_nav.setImageTintList(ColorStateList.valueOf(isActiveTrash ? isOptimizedTrash ? white : attentionColor : isOptimizedTrash ? darkblue : attentionColor));
        t_nav.setBackgroundTintList(ColorStateList.valueOf(isActiveTrash ? darkblue : white));
    }
}