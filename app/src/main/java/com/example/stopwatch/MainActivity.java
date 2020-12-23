package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private long stopoffset;
    private boolean running;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.txt1);
//        chronometer.setFormat("Time: %s");
    }


    public void onClickStart(View view) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - stopoffset);
            chronometer.start();
            running = true;
        }
    }

    public void onClickStop(View view) {
        if(running) {
            chronometer.stop();
            stopoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void onClickreset(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        stopoffset = 0;
    }
}