package com.vcolofati.myworkouttimer.fragments;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vcolofati.myworkouttimer.R;
import com.vcolofati.myworkouttimer.constants.Constants;

public class ChronometerFragment extends Fragment {

    private boolean running;
    private long elapsedTime = 0;
    private Chronometer mChronometer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chronometer, container, false);
        mChronometer = (root.findViewById(R.id.mainChronometer));

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(Constants.IS_RUNNING)) {
                elapsedTime = savedInstanceState.getLong(Constants.ELAPSED_TIME);
                start();
            } else {
                elapsedTime = savedInstanceState.getLong(Constants.ELAPSED_TIME);
                mChronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
            }
        }

        return root;
    }

    public void start() {
        if (!running) {
            mChronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
            mChronometer.start();
            running = true;
        }
    }

    public void stop() {
        if (running) {
            mChronometer.stop();
            elapsedTime = SystemClock.elapsedRealtime() - mChronometer.getBase();
            running = false;
        }
    }

    public void reset() {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        elapsedTime = 0;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        long elapsedTime = SystemClock.elapsedRealtime() - mChronometer.getBase();
        boolean isRunning = this.running;
        outState.putLong(Constants.ELAPSED_TIME, elapsedTime);
        outState.putBoolean(Constants.IS_RUNNING, isRunning);
    }
}