package com.example.drago.roamingtest;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Drago on 4/29/2017.
 */

public class MyRoamingService extends Service {

    CheckNetworkRoaming ck = new CheckNetworkRoaming();
    Timer timer = new Timer();
    private Handler mHandler = new Handler();
    MyRunnable myRunnable = new MyRunnable();
    private static final int SLEEP_TIMER = 5000;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        timer.schedule(new RoamingTask(), 0, SLEEP_TIMER);
        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class RoamingTask extends TimerTask {

        public void run() {
            mHandler.post(myRunnable);
        }
    }

    @Override
    public void onDestroy() {
        Log.d("MyRoamingService", "onDestroy called");
        stopSelf();
        mHandler.removeCallbacks(myRunnable);
        super.onDestroy();
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            Toast.makeText(getApplicationContext(),
                    "Data Roaming : " + ck.checkRoaming(getApplicationContext()),
                    Toast.LENGTH_LONG).show();
        }
    }

}