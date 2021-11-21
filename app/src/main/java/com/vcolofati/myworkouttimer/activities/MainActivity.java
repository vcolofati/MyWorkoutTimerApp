package com.vcolofati.myworkouttimer.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.vcolofati.myworkouttimer.R;
import com.vcolofati.myworkouttimer.util.MyChronometer;

public class MainActivity extends AppCompatActivity {

    private MyChronometer mChronometer = new MyChronometer();
    private Button mStartButton, mStopButton, mResetButton;
    private TextView mTextView2;
    private NumberPicker mNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChronometer.setChronometer(findViewById(R.id.mainChronometer));
        mStartButton = findViewById(R.id.buttonStart);
        mStopButton = findViewById(R.id.buttonStop);
        mResetButton = findViewById(R.id.buttonReset);

        mTextView2 = findViewById(R.id.textView2);
        mNumberPicker = findViewById(R.id.numberPicker);
        mNumberPicker.setMinValue(0);
        mNumberPicker.setMaxValue(10);

        mStartButton.setOnClickListener(v -> mChronometer.start(v));
        mStopButton.setOnClickListener(v -> mChronometer.stop(v));
        mResetButton.setOnClickListener(v -> mChronometer.reset(v));

    }
}