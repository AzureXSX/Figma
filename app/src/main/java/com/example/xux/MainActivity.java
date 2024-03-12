package com.example.xux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textviewBase);
        String fulltext = "I have read and acknowledged the Privacy Policy and the Terms of Service";
        SpannableString spannableString = new SpannableString(fulltext);

        int start = fulltext.indexOf("Privacy Policy");
        int end = start + "Privacy Policy".length();
        ForegroundColorSpan whiteSpan = new ForegroundColorSpan(Color.WHITE);
        spannableString.setSpan(whiteSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        start = fulltext.indexOf("Terms of Service");
        end = start + "Terms of Service".length();
        spannableString.setSpan(whiteSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);


        textView.setText(spannableString);


        AppCompatButton btn = (AppCompatButton) findViewById(R.id.start_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Loading.class);
                startActivity(intent);
            }
        });


        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
}