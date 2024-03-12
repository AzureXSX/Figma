package com.example.xux;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Loading extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        TextView textView = (TextView) findViewById(R.id.loading_label);

        new Thread(new Runnable() {
            public void run() {
                int progress = 0;

                while (progress <= 100) {
                    // Update the progress bar
                    progressBar.setProgress(progress);

                    // Sleep for 200 milliseconds to simulate loading
                    try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

                    // Increment the progress
                    int finalProgress = progress;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("Loading " + finalProgress + "%");
                        }
                    });
                    progress++;
                }

                Intent intent = new Intent(getApplicationContext(), BoostBase.class);
                startActivity(intent);
            }
        }).start();

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
}