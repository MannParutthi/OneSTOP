package com.appsplanet.onestop;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appsplanet.onestop.a1stop.R;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //handle for 2 sec then start age limit sceen
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i = new Intent(MainActivity.this, AgeLimitActivity.class);
                finish();
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
