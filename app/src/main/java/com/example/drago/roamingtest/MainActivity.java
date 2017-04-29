package com.example.drago.roamingtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MyRoamingService.class);
        startService(i);
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, MyRoamingService.class));
        super.onDestroy();
    }
}
