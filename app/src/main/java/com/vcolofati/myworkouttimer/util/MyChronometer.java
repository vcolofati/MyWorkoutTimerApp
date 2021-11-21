package com.vcolofati.myworkouttimer.util;

import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MyChronometer {

    private Chronometer mChronometer;
    private boolean running;
    private long pauseOffset;

    public void setChronometer(Chronometer mChronometer) {
        this.mChronometer = mChronometer;
    }

    public void start(View view) {
        if (!running) {
            mChronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            mChronometer.start();
            running = true;
        }
    }

    public void stop(View view) {
        if (running) {
            mChronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - mChronometer.getBase();
            running = false;
        }
    }

    public void reset(View view) {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
}
