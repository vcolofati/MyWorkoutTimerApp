package com.vcolofati.myworkouttimer.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.vcolofati.myworkouttimer.R;
import com.vcolofati.myworkouttimer.constants.Constants;
import com.vcolofati.myworkouttimer.fragments.ChronometerFragment;

public class MainActivity extends AppCompatActivity {


    private Button mStartButton, mStopButton, mResetButton;
    private NumberPicker mNumberPickerSeries, mNumberPickerMinutes, mNumberPickerSeconds;
    private ChronometerFragment mChronometerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        if (savedInstanceState != null) {
            mChronometerFragment = (ChronometerFragment) getSupportFragmentManager()
                    .findFragmentByTag(Constants.FRAGMENT_TAG);
        } else {
            mChronometerFragment = new ChronometerFragment();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.chronometer_fragment, mChronometerFragment, Constants.FRAGMENT_TAG)
                .commit();

        mStartButton = findViewById(R.id.buttonStart);
        mStopButton = findViewById(R.id.buttonStop);
        mResetButton = findViewById(R.id.buttonReset);

        mNumberPickerSeries = findViewById(R.id.numberPickerSeries);
        mNumberPickerMinutes = findViewById(R.id.numberPickerMin);
        mNumberPickerSeconds = findViewById(R.id.numberPickerSec);

        mNumberPickerSeries.setMinValue(0);
        mNumberPickerSeries.setMaxValue(10);
        mNumberPickerMinutes.setMinValue(0);
        mNumberPickerMinutes.setMaxValue(59);
        mNumberPickerSeconds.setMinValue(0);
        mNumberPickerSeconds.setMaxValue(59);

        mStartButton.setOnClickListener(view -> mChronometerFragment.start());

        mStopButton.setOnClickListener(view -> mChronometerFragment.stop());

        mResetButton.setOnClickListener(view -> mChronometerFragment.reset());
    }

   /* @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "ChronometerFragment", mChronometerFragment);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mChronometerFragment = (ChronometerFragment) getSupportFragmentManager().getFragment(savedInstanceState, "ChronometerFragment");
    }*/
}