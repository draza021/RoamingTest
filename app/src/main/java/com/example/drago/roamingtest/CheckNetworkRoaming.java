package com.example.drago.roamingtest;

/**
 * Created by Drago on 4/29/2017.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class CheckNetworkRoaming {

    // checkNetworkType detects what Network Connection type is active
    public String checkRoaming(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            return "no Connection";
        } else {
            NetworkInfo networkType = connManager.getActiveNetworkInfo();
            return "" + networkType.isRoaming();
        }
    }
}
